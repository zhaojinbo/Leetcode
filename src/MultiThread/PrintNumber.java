package MultiThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrintNumber {
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition conditionOdd = lock.newCondition();
    private static Condition conditionEven = lock.newCondition();

    static class PrintEvenRunnable implements Runnable {

        @Override
        public void run() {
            try {
                lock.lock();
                for (int i = 0; i < 100; i += 2) {
                    System.out.println("偶数线程，打印值：" + i);
                    conditionOdd.signalAll();
                    conditionEven.await();
                }
                conditionOdd.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    static class PrintOddRunnable implements Runnable {

        @Override
        public void run() {
            try {
                lock.lock();
                for (int i = 1; i < 100; i += 2) {
                    System.out.println("奇数线程，打印值：" + i);
                    conditionEven.signalAll();
                    conditionOdd.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new PrintEvenRunnable()).start();
        new Thread(new PrintOddRunnable()).start();
    }

}
