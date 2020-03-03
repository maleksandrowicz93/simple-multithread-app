package example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(ThreadPool::numbers);
        executorService.submit(() -> numbers());
        executorService.submit(() -> numbers());
        executorService.shutdownNow();
        executorService.shutdown();

    }

    private static void numbers() {
        for (int i = 0; i < 999; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

}
