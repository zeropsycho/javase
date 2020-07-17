package javase.thread.executor;

/**
 * 线程池
 */
public class NewCachedThreadPool implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程" + Thread.currentThread().getName());
    }
}
