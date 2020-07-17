package javase.thread.exercise;

public class AccountThreads extends Thread {
    private int balance = 1000;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this) {
                if (balance <= 0) {
                    System.out.println("余额不足，" + Thread.currentThread().getName() + "余额为：" + balance);
                } else {
                    balance = balance - 100;
                    System.out.println(Thread.currentThread().getName() + "准备取款！");
                    System.out.println(Thread.currentThread().getName() + "完成取款，剩余余额：" + balance);
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread( "张三");
        Thread thread1 = new Thread( "妻子");
        thread.start();
        thread1.start();

    }
}
