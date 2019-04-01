package analyse.numerique.matrix;

import analyse.numerique.number.NumberWrapper;

public class TridiagonalMatrix<T extends Number & Comparable<T>, P extends NumberWrapper<T, P>>
        extends AbstractMatrix<T, P> {

    private P[] diag;
    private P[] sup;
    private P[] inf;

    public TridiagonalMatrix(int dimension) throws Exception {
        super(dimension, dimension);
        @SuppressWarnings("unchecked")
        P[] diag = (P[]) new Object[dimension];
        this.diag = diag;
        @SuppressWarnings("unchecked")
        P[] sup = (P[]) new Object[dimension - 1];
        this.sup = sup;
        @SuppressWarnings("unchecked")
        P[] inf = (P[]) new Object[dimension - 1];
        this.inf = inf;
    }

    @Override
    public TridiagonalMatrix<T, P> transposel() {
        return null;
    }

    @Override
    public P get(int i, int j) throws Exception {
        if (i == j)
            return diag[j];
        else if (j == i + 1)
            return sup[j];
        else if (j == i - 1)
            return inf[j - 1];
        else
            return diag[0].zero();
    }

    @Override
    public void set(P x, int i, int j) throws Exception {
        if (i == j)
            diag[j] = x;
        else if (j == i + 1)
            sup[j] = x;
        else if (j == i - 1)
            inf[j - 1] = x;
        else
            throw new Exception("Ce format ne supporte pas ");
    }

    @Override
    public int rows() {
        return diag.length;
    }

    @Override
    public int cols() {
        return diag.length;
    }

    @Override
    public void transpose() {
        P[] temp = sup;
        sup = inf;
        inf = temp;
    }

    @Override
    public void mult(Matrix<T, P> matrix) throws Exception {
        throw new RuntimeException();
    }

    @Override
    public void inverse() throws Exception {
        throw new RuntimeException();
    }

    @Override
    public boolean isSquare() {
        return true;
    }

}