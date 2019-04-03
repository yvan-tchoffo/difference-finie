package analyse.numerique.linear.solvers;

import analyse.numerique.matrix.Matrix;
import analyse.numerique.number.NumberWrapper;
import analyse.numerique.vector.Vector;

/**
 * Solver
 */
public interface Solver<T extends Number & Comparable<T>, P extends NumberWrapper<T, P>> {
    public <Q extends Matrix<T, P>, R extends Vector<T, P>> R solve(Q a, R b, double rerr, double aerr);
}