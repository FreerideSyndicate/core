package co.freeride.core.interfaces.synchronicity;

import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.util.concurrent.ListenableFuture;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @version 1.0.0
 * @author Greg Price - Created on 1/15/17.
 * The {@code AtomicOperations} is an interface the supplies high level default
 * methods as abstractions to atomic operations.
 */

public interface AtomicOperations<T> {

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

    default CompletableFuture<T> generateCompletableTask(CompletableFuture<T> task, Function<T, Throwable> callback) {return null;};

    default void scheduleTasks(Stream<T> tasks) {};

}
