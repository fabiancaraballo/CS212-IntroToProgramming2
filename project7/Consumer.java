import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable {
    private String conName;
    private static final int MAX_WAIT_MS = 10;
    private Producer producer = null;
    private int counter;

    BlockingQueue<String> que = null;

    public Consumer(BlockingQueue<String> que) {
        this.que = que;
    }

    public Consumer(BlockingQueue<String> que, final Producer producer, String newQueName){
        this.conName = newQueName;
        this.que = que;
        this.producer = producer;
    }

    @Override
    public void run() {
        Random random = new Random();



        // waiting 1 second before starting to consume
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            while (!producer.isComplete()) {
                Thread.sleep(random.nextInt(MAX_WAIT_MS));
                String str = que.poll(1000, TimeUnit.MILLISECONDS);

                if(str != null) {
                    counter++;
                    if(counter % 100 == 0){
//                        System.out.printf("Consumed [%s]: %s \n", Thread.currentThread().getName(), str);
                        System.out.printf("\"%s\": %d events consumed \n", conName, counter);
                    }
                    //System.out.printf("Consumed [%s]: %s \n", Thread.currentThread().getName(), str);
                }

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public int getCounter() {
        return counter;
    }
}