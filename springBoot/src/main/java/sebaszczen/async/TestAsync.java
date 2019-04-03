package sebaszczen.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Service
public class TestAsync {

    @Async
    public Future<Integer> returnInt() throws InterruptedException {
        System.out.println("current thread: "+Thread.currentThread().getName());
        Thread.sleep(5000);
        return new AsyncResult<>(new Integer(5));
    }
}
