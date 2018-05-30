package wromaciej.hvac_sim.simulation.thermo.parameters;


import org.jscience.physics.amount.Amount;
import wromaciej.hvac_sim.simulation.thermo.quantities.base.AnyQuantity;
import javax.measure.unit.Unit;
import java.io.Serializable;


public class Parameter<Q extends AnyQuantity> implements Serializable {

    public static final Parameter<?> ONE = amountToParameter(Amount.ONE);

    private Amount<Q> amount;

    private Unit<Q> actualUnit;

    private ParameterType parameterType;

    private boolean userDefined;

    public ParameterType getParameterType() {
        return parameterType;
    }

    public void setParameterType(ParameterType parameterType) {
        this.parameterType = parameterType;
    }

    public Double getValue() {
        if ((isDefined()) && (actualUnit != null))
        return amount.doubleValue(actualUnit);
        else return null;
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

    public boolean isDefined() {
        if (amount != null) return true;
        else return false;
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
        if (actualUnit!=null)
        return actualUnit;
        else return null;
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

    public void calculate(Parameter operations){
        this.amount = operations.amount;
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

    public Parameter abs(){
        Amount resultingAmount=amount.abs();
        return amountToParameter(resultingAmount);
    }

    public Parameter opposite(){
        Amount resultingAmount=amount.opposite();
        return amountToParameter(resultingAmount);
    }

    public boolean isPositive(){
        if (!abs().equals(opposite())) return true;
        else return false;
    }

    public boolean isNegative(){
        return ((!isPositive()) && (!isZero()));
    }

    public boolean isZero(){
        return this.equals(opposite());
    }

    /**
     * Returns value calculated in unit of thermoCP library
     */
    public double getValueInThermoCPUnit(){
        return amount.doubleValue((Unit) Unit.valueOf(parameterType.getStringUnitInThermoCP()) );
    }



    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (getValue() != null) stringBuilder.append(getValue());
        if (getActualUnit() != null) stringBuilder.append(getActualUnit().toString());
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;
        Parameter<Q> thatParameter = (Parameter<Q>) that;
        Amount<Q> thatAmount= (Amount) thatParameter.amount;
        return amount.approximates(thatAmount); //.equals(thatAmount); //
    }

    @Override
    public int hashCode() {

        return amount.hashCode();
    }
}
