package freeride.co.interfaces.synchronicity;


import org.springframework.util.concurrent.FailureCallback;
import org.springframework.util.concurrent.SuccessCallback;

import java.util.concurrent.Future;
import java.util.function.Function;

/**
 * Created by Greg on 1/15/17.
 */

public interface AtomicOperations<T> {

    default void schedule(SuccessCallback<T> task, FailureCallback completion) {};

    default Future<T> generateExecutable(Function<T, Throwable> executable) {return null;};

}
