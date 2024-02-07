package math;

public class CalculatorImpl implements Calculator{
    @Override
    public double add(final double a, final double b) {
        return a + b;
    }

    @Override
    public double sub(final double a, final double b) {
        return this.add(a, -b);
    }
}
