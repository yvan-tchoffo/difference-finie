package analyse.numerique.finite_difference;

import analyse.numerique.Equation;
import analyse.numerique.function.Function;
import analyse.numerique.number.NumberWrapper;

/**
 * Solver
 */
public interface Solver<T extends Number & Comparable<T>, P extends NumberWrapper<T, P>, Q extends Function<T, P>> {
    public Q solve(Equation<T, P, Q> equation);
}