package javase.thread;

/**
 * 卖票 (资源共享，线程同步问题)
 */
public class RunnableDemo implements Runnable {

    private int tick = 5;
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (tick > 0) {
                System.out.println("thrad name" + i + ":" + Thread.currentThread().getName() + "卖出了" + (tick--) + "票");
            }
        }
    }

    public static void main(String[] args) {
        RunnableDemo runnableDemo = new RunnableDemo();
        Thread thread = new Thread(runnableDemo);
        Thread thread1 = new Thread(runnableDemo);
        Thread thread2 = new Thread(runnableDemo);
        Thread thread3 = new Thread(runnableDemo);
        thread.start();
        thread1.start();
        thread2.start();
        thread3.start();

        /*for (int i = 0; i < 5; i++) {
            System.out.println("thrad name" + i + ":" + Thread.currentThread().getName());
        }*/
    }
}
