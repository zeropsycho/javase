package javase.thread.exercise;

/**
 * sleep测试
 */
public class SleepDemo implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "----" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SleepDemo sleepDemo = new SleepDemo();
        Thread thread = new Thread(sleepDemo);
        thread.start();
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1001);
                System.out.println(Thread.currentThread().getName() + "---" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
