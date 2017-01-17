package co.freeride.core.interfaces.synchronicity;


import org.springframework.util.concurrent.FailureCallback;
import org.springframework.util.concurrent.SuccessCallback;

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

    default void scheduleTask(SuccessCallback<T> task, FailureCallback completion) {};

    default CompletableFuture<T> generateExecutableTask(Function<T, Throwable> executable) {return null;};

    default void scheduleTasks(Stream<T> tasks) {};

}
