import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    private String name;
    private boolean isComplete = false;
    private static final int MAX_WAIT_MS = 500;
    private static final int MAX_STRINGS = 1000;

    private BlockingQueue<String> que = null;

    public Producer(BlockingQueue<String> que, String queName) {
        this.que = que;
        //System.out.println("que capacity = "+ que.remainingCapacity());
        this.name = queName;


    }

    public boolean isComplete() {
        return isComplete;
    }

    @Override
    public void run() {
        Random random = new Random();

        for (int i = 0; i <= MAX_STRINGS; ++i) {
            try {
                que.put(random.nextInt(5000) + "");

                if(i % 100 == 0 && i != 0) {
                    System.out.printf("\"%s\": %d events produced \n", name, i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        isComplete = true;
    }
}