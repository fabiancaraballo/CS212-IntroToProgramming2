import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.Random;


public class Producer implements Runnable {
    private String name;
    private boolean isComplete = false;
    private static final int MAX_WAIT_MS = 500;
    private static final int MAX_STRINGS = 1000;
    private static int totalMessageCounter = 0;
    private static boolean completed = false;

    private LinkedList<String> que = null;
    private int pCounter = 0;


    public Producer(LinkedList<String> que, String queName) {
        this.que = que;
        this.name = queName;


    }


    @Override
    public void run() {
        Random random = new Random();

        while(totalMessageCounter < MAX_STRINGS){
            synchronized (que) {
                try {
                    while (que.size() == 2) {
                        que.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            synchronized (que) {
                que.push(totalMessageCounter++ + "");
                if(totalMessageCounter % 100 == 0 && totalMessageCounter != 0) {
                    System.out.printf("\"%s\": %d events produced. \n", name, totalMessageCounter);
                }
                pCounter++;
                que.notify();
            }
        }
        completed = true;

    }

    public int getpCounter() {
        return pCounter;
    }

    public static boolean isCompleted() {
        return completed;
    }
}