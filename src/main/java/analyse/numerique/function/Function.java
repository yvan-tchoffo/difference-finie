package analyse.numerique.function;

import analyse.numerique.number.NumberWrapper;

/**
 * Function
 */
public interface Function<T extends Number & Comparable<T>, P extends NumberWrapper<T, P>> {
    @SuppressWarnings("unchecked")
    public P get(P... args);

    @SuppressWarnings("unchecked")
    public P get(T... args);
}