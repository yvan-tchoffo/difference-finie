package analyse.numerique.number;

/**
 * DoubleWrapper
 */
public class DoubleWrapper extends AbstractNumberWrapper<Double, DoubleWrapper> {
    private Double value = 0.0;

    public DoubleWrapper(Double value) {
        this.value = value;
    }

    @Override
    public DoubleWrapper add(Double number) {
        return new DoubleWrapper(value + number);
    }

    @Override
    public DoubleWrapper add(Integer number) {
        return add(number.doubleValue());
    }

    @Override
    public DoubleWrapper sub(Double number) {
        return new DoubleWrapper(value - number);
    }

    @Override
    public DoubleWrapper sub(Integer number) {
        return sub(number.doubleValue());
    }

    @Override
    public DoubleWrapper mult(Double number) {
        return new DoubleWrapper(value * number);
    }

    @Override
    public DoubleWrapper mult(Integer number) {
        return mult(number.doubleValue());
    }

    @Override
    public DoubleWrapper div(Double number) {
        return new DoubleWrapper(value / number);
    }

    @Override
    public DoubleWrapper div(Integer number) {
        return div(number.doubleValue());
    }

    @Override
    public DoubleWrapper abs() {
        return new DoubleWrapper(this.value < 0 ? 0.0 - value : value);
    }

    @Override
    public Double get() {
        return value;
    }

    @Override
    public DoubleWrapper zero() {
        return new DoubleWrapper(0.0);
    }

    @Override
    public DoubleWrapper parseDouble(Double d) {
        return new DoubleWrapper(d);
    }

}