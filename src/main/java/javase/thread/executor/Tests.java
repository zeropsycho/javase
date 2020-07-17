package javase.thread.executor;

import java.util.concurrent.*;

public class Tests {

    public static void main(String[] args) {
//        newCached();
        scheduledThread();
    }

    /**
     * 最大线程数：Integer.MAX;不推荐使用 newCachedThreadPool
     */
    public static void newCached() {
        NewCachedThreadPool newCachedThreadPool = new NewCachedThreadPool();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 15; i++) {
            executorService.execute(newCachedThreadPool);
        }
    }

    public static void scheduledThread() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(5);
        scheduledThreadPoolExecutor.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("延迟三秒");
            }
        }, 3, TimeUnit.SECONDS);
    }
}
