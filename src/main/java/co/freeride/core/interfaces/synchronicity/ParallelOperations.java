package co.freeride.core.interfaces.synchronicity;

/**
 * @version 1.0.0
 * @author Greg Price - Created on 1/15/17.
 * The {@code ParallelOperations} is an interface the supplies high level
 * methods as abstractions to atomic parralel processor operations. The Type
 * can be assigned to an AtomicOperation.
 * @see AtomicOperations
 */

public interface ParallelOperations<T extends AtomicOperations<? super T>> {

}
