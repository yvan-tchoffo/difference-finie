package analyse.numerique.matrix;

import analyse.numerique.number.NumberWrapper;

public abstract class AbstractMatrix<T extends Number & Comparable<T>, P extends NumberWrapper<T, P>>
        implements Matrix<T, P> {

    public abstract AbstractMatrix<T, P> transposel();

    protected AbstractMatrix() {
    }

    protected AbstractMatrix(int rows, int columns) throws Exception {
        if (rows < 1)
            throw new Exception("Le nombre de lignes doit être supérieure à 0");
        if (columns < 1)
            throw new Exception("le nombre de colonnes être supérieur à 0");
    }
}