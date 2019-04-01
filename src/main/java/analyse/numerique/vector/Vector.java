package analyse.numerique.vector;

import analyse.numerique.matrix.Matrix;
import analyse.numerique.number.NumberWrapper;

/**
 * Vector
 */
public interface Vector<T extends Number & Comparable<T>, P extends NumberWrapper<T, P>> extends Matrix<T, P> {

    default void set(P x, int i) throws Exception {
        set(x, i, 0);
    }

    default P get(int i) throws Exception {
        return get(i, 0);
    }

    @Override
    default int cols() {
        return 1;
    }

    @Override
    default boolean isSquare() {
        return false;
    }

}