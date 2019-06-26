import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable {
    private String conName;
    private static final int MAX_WAIT_MS = 10;
    private int counter;


    LinkedList<String> que = null;

    public Consumer(LinkedList<String> que) {
        this.que = que;
    }

    public Consumer(LinkedList<String> que, String newQueName) {
        this.conName = newQueName;
        this.que = que;
    }

    @Override
    public void run() {
        Random random = new Random();

        while(true){
            try {
                Thread.sleep(random.nextInt(MAX_WAIT_MS));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (que) {
                while (que.isEmpty()) {
                    try {
                        que.wait();
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            synchronized (que) {
                String msg = que.pollLast();
                counter++;
                if(counter % 100 == 0 && counter != 0) {
                    System.out.printf("\"%s\": %d events consumed. \n", conName, counter);
                }
                que.notify();
            }

            if(Producer.isCompleted() && que.isEmpty())
                break;
        }


        }

        public int getCounter() {
            return counter;
        }
    }
