package analyse.numerique;

import analyse.numerique.function.Function;
import analyse.numerique.number.NumberWrapper;

/**
 * Equation
 */
public class Equation<T extends Number & Comparable<T>, P extends NumberWrapper<T, P>, Q extends Function<T, P>> {
    private final Q a, b, c;
    private final P v_0, v_1;

    public Equation(Q a, Q b, Q c, P v_0, P v_1) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.v_0 = v_0;
        this.v_1 = v_1;
    }

    /**
     * @return the a
     */
    public Q getA() {
        return a;
    }

    /**
     * @return the b
     */
    public Q getB() {
        return b;
    }

    /**
     * @return the c
     */
    public Q getC() {
        return c;
    }

    /**
     * @return the v_0
     */
    public P getV_0() {
        return v_0;
    }

    /**
     * @return the v_1
     */
    public P getV_1() {
        return v_1;
    }

}