import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class ExecutorServiceExample {
    public static void main(String[] args) {
        System.out.println("Main thread started");
        ExecutorService executors = Executors.newFixedThreadPool(3);
        IntStream.range(0, 10).forEach(i -> executors.execute(new Task()));
        System.out.println("Main thread completed");
        executors.shutdown();
    }
}
class Task implements Runnable {

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println("current thread: "+ threadName);
    }
}