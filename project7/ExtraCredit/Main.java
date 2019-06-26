import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> queue = new LinkedList<>();

        ExecutorService executor = Executors.newCachedThreadPool();
        Producer p1 = new Producer(queue, "Producer 1");
        Consumer c1 = new Consumer(queue,  "Consumer 1");
        executor.submit(p1);
        executor.submit(c1);


        Producer p2 = new Producer(queue, "Producer 2");
        Consumer c2 = new Consumer(queue,  "Consumer 2");
        executor.submit(p2);
        executor.submit(c2);

        executor.shutdown();
        try {
            executor.awaitTermination(20, TimeUnit.SECONDS);
            System.out.println("Summary:");
            System.out.printf("\"Producer 1\" produces %s events \n", p1.getpCounter());
            System.out.printf("\"Producer 2\" produces %s events \n", p2.getpCounter());
            System.out.printf("\"Consumer 1\" produces %s events \n", c1.getCounter());
            System.out.printf("\"Consumer 2\" produces %s events \n", c2.getCounter());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}