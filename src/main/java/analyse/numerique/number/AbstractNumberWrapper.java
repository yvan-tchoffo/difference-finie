package analyse.numerique.number;

/**
 * AbstractNumber
 */
public abstract class AbstractNumberWrapper<T extends Number & Comparable<T>, P extends NumberWrapper<T, P>>
                implements NumberWrapper<T, P> {

}