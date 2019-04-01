package analyse.numerique.matrix;

import analyse.numerique.number.NumberWrapper;

public interface Matrix<T extends Number & Comparable<T>, P extends NumberWrapper<T, P>> {
    public P get(int i, int j) throws Exception;

    public void set(P x, int i, int j) throws Exception;

    public int rows();

    public int cols();

    default boolean isSquare() {
        return this.cols() == this.rows();
    };

    public void transpose();

    default void add(Matrix<T, P> matrix) throws Exception {
        if (rows() != matrix.rows() || cols() != matrix.cols())
            throw new Exception("Matrices need to have the same dimensions");
        for (int i = 0; i <= rows(); i++)
            for (int j = 0; j < cols(); j++)
                set(get(i, j).add(matrix.get(i, j)), i, j);
    }

    default void sub(Matrix<T, P> matrix) throws Exception {
        if (rows() != matrix.rows() || cols() != matrix.cols())
            throw new Exception("Matrices need to have the same dimensions");
        for (int i = 0; i <= rows(); i++)
            for (int j = 0; j < cols(); j++)
                set(get(i, j).sub(matrix.get(i, j)), i, j);
    }

    public void mult(Matrix<T, P> matrix) throws Exception;

    public void inverse() throws Exception;

}