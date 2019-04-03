package analyse.numerique.function;

import analyse.numerique.number.NumberWrapper;

/**
 * Function
 */
public interface Function<T extends Number & Comparable<T>, P extends NumberWrapper<T, P>>
        extends java.util.function.Function<P, P> {

}