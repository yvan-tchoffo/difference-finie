package analyse.numerique.vector;

import analyse.numerique.matrix.Matrix;
import analyse.numerique.number.NumberWrapper;

public class SimpleVector<T extends Number & Comparable<T>, P extends NumberWrapper<T, P>>
        extends AbstractVector<T, P> {

    protected P[] vector;

    public SimpleVector(int dimension) {
        @SuppressWarnings("unchecked")
        P[] vector = (P[]) new Object[dimension];
        this.vector = vector;
    }

    public SimpleVector(P[] vector) {
        this.vector = vector;
    }

    @Override
    public P get(int i, int j) throws Exception {
        if (j != 0)
            throw new Exception();
        return vector[i];
    }

    @Override
    public void set(P x, int i, int j) throws Exception {
        if (j != 0)
            throw new Exception();
        vector[i] = x;
    }

    @Override
    public int rows() {
        return vector.length;
    }

    @Override
    public void transpose() {
        throw new RuntimeException();
    }

    @Override
    public void mult(Matrix<T, P> matrix) throws Exception {
        throw new RuntimeException();
    }

    @Override
    public void inverse() throws Exception {
        throw new RuntimeException();
    }

}