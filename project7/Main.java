import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>(100);

        ExecutorService executor = Executors.newCachedThreadPool();
        Producer p1 = new Producer(queue, "Producer 1");
        executor.submit(p1);
        Consumer c1 = new Consumer(queue, p1, "Consumer 1");
        Consumer c2 = new Consumer(queue, p1,"Consumer 2");
        executor.submit(c1);
        executor.submit(c2);
        executor.shutdown();

        try {
            executor.awaitTermination(20, TimeUnit.SECONDS);
                System.out.println("Summary:");
                System.out.println(("\"Producer 1\" produces 1000 events"));
                System.out.printf("\"Consumer 1\" produces %s events \n", c1.getCounter());
                System.out.printf("\"Consumer 2\" produces %s events \n", c2.getCounter());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}