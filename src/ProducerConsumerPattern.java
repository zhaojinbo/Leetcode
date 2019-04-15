import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProducerConsumerPattern {

    public static void main(String args[]) {
        BlockingQueue bufQueue = new LinkedBlockingQueue();
        Thread prodThread = new Thread(new Producer(bufQueue));
        Thread consThread = new Thread(new Consumer(bufQueue));
        prodThread.start();
        consThread.start();
    }

    //Producer
    static class Producer implements Runnable {
        private final BlockingQueue<String> bufQueue;

        Producer(BlockingQueue<String> bufQueue) {
            this.bufQueue = bufQueue;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    bufQueue.put(String.valueOf(i));
                    System.out.println("Produced: " + i);
                    Thread.sleep(10);
                }
                bufQueue.put("OVER");// 设置标志位表示结束
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //Consumer
    static class Consumer implements Runnable {
        private final BlockingQueue<String> bufQueue;

        Consumer(BlockingQueue<String> bufQueue) {
            this.bufQueue = bufQueue;
        }

        @Override
        public void run() {
            try {
                String x = null;
                while (!(x = bufQueue.take()).equals("OVER")) {
                    System.out.println("Consumed: " + x);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

