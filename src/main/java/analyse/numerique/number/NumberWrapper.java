package analyse.numerique.number;

public interface NumberWrapper<T extends Number & Comparable<T>, P extends NumberWrapper<T, P>> {
    default P add(P number) {
        return add(number.get());
    }

    public P add(T number);

    public P add(Integer number);

    public P add(Double number);

    default P sub(P number) {
        return sub(number.get());
    }

    public P sub(T number);

    public P sub(Integer number);

    public P sub(Double number);

    default P mult(P number) {
        return mult(number.get());
    }

    public P mult(T number);

    public P mult(Integer number);

    public P mult(Double number);

    default P div(P number) {
        return div(number.get());
    }

    public P div(T number);

    public P div(Integer number);

    public P div(Double number);

    public P abs();

    public T get();

    public P zero();

    public P parseDouble(Double d);

}