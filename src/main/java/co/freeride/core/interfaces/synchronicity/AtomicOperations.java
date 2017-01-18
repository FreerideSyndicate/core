package co.freeride.core.interfaces.synchronicity;

import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @version 1.0.0
 * @author Greg Price - Created on 1/15/17.
 * The {@code AtomicOperations} is an interface the supplies high level default
 * methods as abstractions to atomic operations.
 */

public interface AtomicOperations<T, R extends Runnable> {

    /**
     * Default implementation schedules a listenable future with the default settings.
     * @param task The task to execute.
     * @param callback The callback interface anonymous class. Override onSuccess, onFailure
     * To achieve desired results.
     * @see <a href="http://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/util/concurrent/ListenableFuture.html">Spring Documentations</a>
     */

    default void scheduleTask(ListenableFuture<T> task, ListenableFutureCallback<T> callback) {
        task.addCallback(callback);
    };

    /**
     * Default implementation returns a generated CompleteableFuture from the ForkJoinPool
     * @param task The supplier task to execute.
     * @return CompletableFuture
     */

    default CompletableFuture<T> generateCompletableTask(Supplier<T> task) {
        return CompletableFuture.supplyAsync(task);
    };

    /**
     * Default implementation takes a List of tasks and then uses the default thread
     * pool and supplied Functional Interface to return a stream of mapped objects.
     * @param tasks A List of type T to which the functional interface will be mapped to.
     * @param action An implementation of the supplied interfaced to map to each task in the tasks.
     * @return Stream
     */

    default Stream<R> generateMappedStream(List<T> tasks, Function<? super T, ? extends R> action) {
        return tasks.stream().map(action);
    };

}


