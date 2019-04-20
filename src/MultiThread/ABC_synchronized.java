package MultiThread;

public class ABC_synchronized {
    static private final Object lockA = new Object();
    static private final Object lockB = new Object();
    static private final Object lockC = new Object();

    static class PrintARunnable implements Runnable {

        @Override
        public void run() {
            synchronized (lockC) {
                for (int i = 0; i < 11; i++) {
                    synchronized (lockA) {
                        if (i<10){
                            System.out.print(Thread.currentThread().getName());
                        }
                        lockA.notifyAll();
                    }
                    try {
                        if (i<10){
                            lockC.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class PrintBRunnable implements Runnable {

        @Override
        public void run() {
            synchronized (lockA) {
                for (int i = 0; i < 11; i++) {
                    synchronized (lockB) {
                        if (i<10){
                            System.out.print(Thread.currentThread().getName());
                        }
                        lockB.notifyAll();
                    }
                    try {
                        if (i<10){
                            lockA.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class PrintCRunnable implements Runnable {

        @Override
        public void run() {
            synchronized (lockB) {
                for (int i = 0; i < 10; i++) {
                    synchronized (lockC) {
                        System.out.print(Thread.currentThread().getName());
                        lockC.notifyAll();
                    }
                    try {
                        lockB.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new PrintARunnable(), "A").start();
        new Thread(new PrintBRunnable(), "B").start();
        new Thread(new PrintCRunnable(), "C").start();
    }

}
