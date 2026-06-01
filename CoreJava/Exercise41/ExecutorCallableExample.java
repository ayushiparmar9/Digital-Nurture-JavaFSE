import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorCallableExample {

    public static void main(String[] args)
            throws Exception {

        ExecutorService executor =
                Executors.newFixedThreadPool(3);

        List<Callable<Integer>> tasks =
                new ArrayList<>();

        for(int i = 1; i <= 5; i++) {

            int num = i;

            tasks.add(
                    () -> num * num
            );
        }

        List<Future<Integer>> results =
                executor.invokeAll(tasks);

        for(Future<Integer> future : results) {

            System.out.println(
                    future.get()
            );
        }

        executor.shutdown();
    }
}