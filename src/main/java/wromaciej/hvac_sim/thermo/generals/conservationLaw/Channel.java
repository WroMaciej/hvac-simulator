package wromaciej.hvac_sim.thermo.generals.conservationLaw;

import wromaciej.hvac_sim.solver.externals.ChannelSolver;
import wromaciej.hvac_sim.solver.internals.Solvable;
import wromaciej.hvac_sim.solver.result.SolverResult;
import wromaciej.hvac_sim.thermo.generals.Bondable;
import wromaciej.hvac_sim.thermo.generals.Item;
import wromaciej.hvac_sim.thermo.generals.bonds.BondDirection;
import wromaciej.hvac_sim.thermo.generals.bonds.InletDeviceBond;
import wromaciej.hvac_sim.thermo.generals.bonds.OutletDeviceBond;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.ParameterType;
import wromaciej.hvac_sim.thermo.quantities.extensive.HeatFlow;
import wromaciej.hvac_sim.thermo.quantities.extensive.MassFlow;
import wromaciej.hvac_sim.thermo.quantities.specific.PressureDifference;
import wromaciej.hvac_sim.thermo.quantities.specific.SpecificEnthalpy;
import wromaciej.hvac_sim.thermo.streams.model.MatterStream;

import javax.measure.unit.SI;

public class Channel<T extends MatterStream> implements Solvable, Bondable {


    private final Item ownerItem;
    private final InletDeviceBond<T> inletDeviceBond;
    private final OutletDeviceBond<T> outletDeviceBond;

    private T inletStream;
    private T outletStream;

    /**
     * Pressure loss through the channel
     */
    private Parameter<PressureDifference> pressureDrop;
    /**
     * Additional mass flow in/out (Use only for low flows)
     */
    private ParameterWithDirection extraMassFlow;

    /**
     * Heat flow
     */
    private ParameterWithDirection heatFlow;
    private ParameterWithDirection specificEnthalpyDifference;
    private Parameter<MassFlow> massFlowToSpecificEnthalpyCalculation;

    private ChannelSolver channelSolver;
    private boolean isSolved;

    public Channel(Item ownerItem, InletDeviceBond<T> inletDeviceBond, OutletDeviceBond<T> outletDeviceBond, Parameter<PressureDifference> pressureDrop, ParameterWithDirection heatFlow, ParameterWithDirection extraMassFlow) {
        this.ownerItem = ownerItem;
        this.inletDeviceBond = inletDeviceBond;
        this.outletDeviceBond = outletDeviceBond;
        this.pressureDrop = pressureDrop;
        this.heatFlow = heatFlow;
        this.specificEnthalpyDifference = new ParameterWithDirection(new Parameter<>(SI.JOULE.divide(SI.KILOGRAM).asType(SpecificEnthalpy.class)), heatFlow.getDirection());
        this.extraMassFlow = extraMassFlow;
        calculateSpecificEnthalpyDifferenceFromHeatFlow();
    }

    public InletDeviceBond<T> getInletDeviceBond() {
        return inletDeviceBond;
    }

    public OutletDeviceBond<T> getOutletDeviceBond() {
        return outletDeviceBond;
    }

    public T getInletStream() {
        inletStream = inletDeviceBond.getTargetBond().getOwnerItem();
        return inletStream;
    }

    public T getOutletStream() {
        outletStream = outletDeviceBond.getTargetBond().getOwnerItem();
        return outletStream;
    }

    public Item getOwnerItem() {
        return ownerItem;
    }


    public ChannelSolver getChannelSolver() {
        return channelSolver;
    }

    public void setChannelSolver(ChannelSolver channelSolver) {
        this.channelSolver = channelSolver;
    }

    public void setSolved(boolean solved) {
        isSolved = solved;
    }

    private void calculateMassFlowToSpecificEnthalpyCalculation() {
        if ((inletStream != null) && (outletStream != null)){
            if ((inletStream.getMassFlow() != null) && (outletStream.getMassFlow() != null)) {
                massFlowToSpecificEnthalpyCalculation = inletStream.getMassFlow().plus(outletStream.getMassFlow()).divide(2.0);
            } else if (inletStream.getMassFlow() != null) massFlowToSpecificEnthalpyCalculation = inletStream.getMassFlow();
            else if (outletStream.getMassFlow() != null) massFlowToSpecificEnthalpyCalculation = outletStream.getMassFlow();
            else massFlowToSpecificEnthalpyCalculation = new Parameter<>();
        }
        else massFlowToSpecificEnthalpyCalculation = new Parameter<>();
    }

    public void calculateHeatFlowFromSpecificEnthalpyDifference() {
        calculateMassFlowToSpecificEnthalpyCalculation();
        if (massFlowToSpecificEnthalpyCalculation.isDefined()) {
            if ((specificEnthalpyDifference != null) && (specificEnthalpyDifference.getParameter().isDefined())) {
                this.heatFlow.getParameter().setAmount(specificEnthalpyDifference.getParameter().times(massFlowToSpecificEnthalpyCalculation).getAmount());
                heatFlow.getParameter().setAmount(heatFlow.getParameter().abs().getAmount());
                heatFlow.setDirection(specificEnthalpyDifference.getDirection());
            }
        }
    }

    public void calculateSpecificEnthalpyDifferenceFromHeatFlow() {
        calculateMassFlowToSpecificEnthalpyCalculation();
        if (massFlowToSpecificEnthalpyCalculation.isDefined()) {
            if ((heatFlow != null) && (heatFlow.getParameter() != null) && (heatFlow.getParameter().isDefined()) && (heatFlow.getDirection() != null)) {
                this.specificEnthalpyDifference.getParameter().setAmount(heatFlow.getParameter().divide(massFlowToSpecificEnthalpyCalculation).getAmount());
                specificEnthalpyDifference.setDirection(heatFlow.getDirection());
            }
        }
    }

    public ParameterWithDirection getHeatFlow() {
        return heatFlow;
    }

    public void setHeatFlow(ParameterWithDirection heatFlow) {
        this.heatFlow = heatFlow;
        calculateSpecificEnthalpyDifferenceFromHeatFlow();
    }

    public ParameterWithDirection getSpecificEnthalpyDifference() {
        return specificEnthalpyDifference;
    }

    public void setSpecificEnthalpyDifference(ParameterWithDirection specificEnthalpyDifference) {
        this.specificEnthalpyDifference = specificEnthalpyDifference;
        calculateHeatFlowFromSpecificEnthalpyDifference();
    }

    public ParameterWithDirection getExtraMassFlow() {
        return extraMassFlow;
    }

    public void setExtraMassFlow(ParameterWithDirection extraMassFlow) {
        this.extraMassFlow = extraMassFlow;
    }

    public Parameter<PressureDifference> getPressureDrop() {
        return pressureDrop;
    }

    public void setPressureDrop(Parameter<PressureDifference> pressureDrop) {
        this.pressureDrop = pressureDrop;
    }

    @Override
    public SolverResult solve() {
        return channelSolver.solve(this);
    }

    @Override
    public boolean isSolved() {
        return isSolved;
    }
}
