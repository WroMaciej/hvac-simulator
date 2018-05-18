package wromaciej.hvac_sim.thermo.matter.fluids.parameters;


import org.jscience.physics.amount.Amount;
import wromaciej.hvac_sim.thermo.quantities.base.AnyQuantity;
import javax.measure.unit.Unit;


public class Parameter<Q extends AnyQuantity> {

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
        amount = amount.plus(that.getAmount());
        return this;
    }

    public Parameter minus (Parameter that){
        amount = amount.minus(that.getAmount());
        return this;
    }

    public Parameter times (double factor){
        amount = amount.times(factor);
        return this;
    }


    public Parameter times (Parameter that){
        amount = (Amount<Q>) amount.times(that.getAmount());
        return this;
    }

    public Parameter divide (double factor){
        amount = amount.divide(factor);
        return this;
    }

    public Parameter divide (Parameter that){
        amount = (Amount<Q>) amount.divide(that.getAmount());
        return this;
    }

    public Parameter power (int exp){
        amount = (Amount<Q>) amount.pow(exp);
        return this;
    }

    public Parameter inverse(){
        amount = (Amount<Q>)  amount.inverse();
        return this;
    }

    public Parameter abs(){
        amount = amount.abs();
        return this;
    }

    public Parameter opposite(){
        amount = amount.opposite();
        return this;
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
