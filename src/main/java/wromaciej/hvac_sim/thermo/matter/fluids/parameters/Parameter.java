package wromaciej.hvac_sim.thermo.matter.fluids.parameters;


import org.jscience.physics.amount.Amount;
import wromaciej.hvac_sim.thermo.quantities.base.AnyQuantity;
import javax.measure.unit.Unit;


public class Parameter<Q extends AnyQuantity> {

    public static final Parameter<?> ONE = amountToParameter(Amount.ONE);

    private Amount<Q> amount;

    private Unit<Q> actualUnit;

    private ParameterType parameterType;

    private boolean userDefined = false;

    public ParameterType getParameterType() {
        return parameterType;
    }

    public void setParameterType(ParameterType parameterType) {
        this.parameterType = parameterType;
    }

    public Double getValue() {
        return amount.doubleValue(actualUnit);
    }

    public void setValue(double value) {
        amount = Amount.valueOf(value, actualUnit);
    }

    public Amount<Q> getAmount() {
        return amount;
    }

    public void setAmount(Amount<Q> amount) {
        this.amount = amount;
    }

    public Parameter(){
        this.parameterType=ParameterType.OTHER;
    }

    public Parameter(ParameterType parameterType){
        this.parameterType = parameterType;
    }

    public Parameter(ParameterType parameterType, Unit<Q> unitInUnitSystem) {
        this.parameterType = parameterType;
        this.actualUnit = unitInUnitSystem;
    }

    public Parameter(ParameterType parameterType, Unit<Q> unitInUnitSystem, double value) {
        this.parameterType = parameterType;
        this.actualUnit = unitInUnitSystem;
        setValue(value);
    }

    public Parameter(Unit<Q> unitInUnitSystem) {
        this.parameterType = ParameterType.OTHER;
        this.actualUnit = unitInUnitSystem;
    }

    public Parameter(Unit<Q> unitInUnitSystem, double value) {
        this.parameterType = ParameterType.OTHER;
        this.actualUnit = unitInUnitSystem;
        setValue(value);
    }

    public Unit<Q> getActualUnit() {
        return actualUnit;
    }

    public void setActualUnit(Unit<Q> actualUnit) {
        this.actualUnit = actualUnit;
        //amount = Amount.valueOf(getValue(),actualUnit);
    }

    public boolean isUserDefined() {
        return userDefined;
    }

    public void setUserDefined(boolean userDefined) {
        this.userDefined = userDefined;
    }

    public static Parameter amountToParameter(Amount resultingAmount) {
        Unit resultingUnit=resultingAmount.getUnit();
        Parameter resultingParameter=new Parameter(resultingUnit);
        resultingParameter.setAmount(resultingAmount);
        return resultingParameter;
    }

    public Parameter plus (Parameter that){
        Amount resultingAmount=amount.plus(that.getAmount());
        return amountToParameter(resultingAmount);
    }

    public Parameter minus (Parameter that){
        Amount resultingAmount=amount.minus(that.getAmount());
        return amountToParameter(resultingAmount);
    }

    public Parameter times (double factor){
        Amount resultingAmount=amount.times(factor);
        return amountToParameter(resultingAmount);
    }


    public Parameter times (Parameter that){
        Amount resultingAmount=amount.times(that.getAmount());
        return amountToParameter(resultingAmount);
    }

    public Parameter divide (double factor){
        Amount resultingAmount=amount.divide(factor);
        return amountToParameter(resultingAmount);
    }

    public Parameter divide (Parameter that){
        Amount resultingAmount=amount.divide(that.getAmount());
        return amountToParameter(resultingAmount);
    }

    public Parameter power (int exp){
        Amount resultingAmount=amount.pow(exp);
        return amountToParameter(resultingAmount);
    }

    public Parameter inverse(){
        Amount resultingAmount=amount.inverse();
        return amountToParameter(resultingAmount);
    }

    /**
     * Returns value calculated in unit of thermoCP library
     */
    public double getValueInThermoCPUnit(){
        return amount.doubleValue((Unit) Unit.valueOf(parameterType.getStringUnitInThermoCP()) );
    }



    @Override
    public String toString() {
        return getValue() + getActualUnit().toString();
    }

    @Override
    public boolean equals(Object that) {
        System.out.println(this + " is equal"+ that +" ?");

        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;
        Parameter<Q> thatParameter = (Parameter<Q>) that;
        Amount<Q> thatAmount= (Amount) thatParameter.amount;
        return amount.equals(thatAmount); //.approximates(thatAmount);
    }

    @Override
    public int hashCode() {

        return amount.hashCode();
    }
}
