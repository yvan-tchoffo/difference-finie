package analyse.numerique.vector;

import analyse.numerique.number.NumberWrapper;

abstract class AbstractVector<T extends Number & Comparable<T>, P extends NumberWrapper<T, P>> implements Vector<T, P> {

}