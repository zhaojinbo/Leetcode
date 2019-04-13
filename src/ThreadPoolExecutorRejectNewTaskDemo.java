import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池触发 RejectedExecutionHandler拒绝新提交任务的场景模拟 demo
 *
 * @author zhangzhiyi
 * @version 1.0
 * @createTime 2016/2/25 13:53
 * @projectName ThreadPoolExecutorTest
 */
public class ThreadPoolExecutorRejectNewTaskDemo {

    // 线程池的最大容量
    private static final int MAX_POOL_SIZE = 3;
    // 阻塞队列的容量
    private static final int QUEUE_CAPACITY = 2;
    // 非核心线程处于空闲状态的最长时间
    private static final int KEEP_ALIVE_TIME_VALUE = 1;
    // 线程池对象
    private static final ThreadPoolExecutor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(
            MAX_POOL_SIZE, MAX_POOL_SIZE,
            KEEP_ALIVE_TIME_VALUE, TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>(QUEUE_CAPACITY),
            new MyThreadFactory());

    public static void main(String[] args) {
        // 模拟线程池及其内部的队列都已满后, 继续向其提交新任务将会被拒绝的场景
        threadPoolFullToRejectNewTask();

        // 模拟线程池被关闭(shutdown)后, 继续向其提交新任务将会被拒绝的场景
//        shutdownThreadPoolToRejectNewTask();
    }

    /**
     * 模拟线程池被关闭(shutdown)后, 继续向其提交新任务将会被拒绝的场景
     */
    private static void shutdownThreadPoolToRejectNewTask() {
        MyRunnable r = new MyRunnable();

        int cycleCount = Math.max(MAX_POOL_SIZE - 1, 0);

        // 先提交(MAX_POOL_SIZE - 1)个任务. 显然, 线程池此时还未满
        for (int i = 0; i < cycleCount; i++) {
            System.out.println("提交任务" + i);
            THREAD_POOL_EXECUTOR.execute(r);
        }
        // 在线程池未满的情况下关闭线程池.
        THREAD_POOL_EXECUTOR.shutdown();

        // 在线程池已处于关闭(SHUTDOWN)的状态下
        if (THREAD_POOL_EXECUTOR.isShutdown()) {
            try {
                System.out.println("提交任务" + cycleCount);
                Thread.sleep(10);
                // 在线程池未满但却已经关闭了的情况下, 继续向该线程池中提交任务.
                THREAD_POOL_EXECUTOR.execute(r);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 模拟线程池及其内部的队列都已满后, 继续向其提交新任务将会被拒绝的场景
     */
    private static void threadPoolFullToRejectNewTask() {
        MyRunnable r = new MyRunnable();
        // 循环提交任务的总次数. 该总次数等于"线程池的最大线程容量和阻塞队列的容量之和", 在执行完
        // 该循环后, 线程池和阻塞队列都已满.
        int cycleCount = MAX_POOL_SIZE + QUEUE_CAPACITY;

        for (int i = 0; i < cycleCount; i++) {
            System.out.println("提交任务" + i);
            THREAD_POOL_EXECUTOR.execute(r);
        }
        // 当前已提交的任务数
        int tasksCount = cycleCount;

        // 在线程池和阻塞队列都已满的情况下, 继续提交任务.
        try {
            System.out.println("提交任务" + (tasksCount));
            Thread.sleep(10);
            THREAD_POOL_EXECUTOR.execute(r);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 自定义的线程工厂类, 用于为线程池创建线程对象.
     */
    private static class MyThreadFactory implements ThreadFactory {
        static int threadNumber = 0;

        @Override
        public Thread newThread(Runnable r) {
            String threadName = "thread-" + (threadNumber++);
            System.out.println("创建线程 " + threadName);
            return new Thread(r, threadName);
        }
    }

    /**
     * 表示向线程池提交的任务的 Runnable实现类
     */
    private static class MyRunnable implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}