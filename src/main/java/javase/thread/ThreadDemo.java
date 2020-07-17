package javase.thread;

/**
 * 卖票
 */
public class ThreadDemo extends Thread{

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
        ThreadDemo demo = new ThreadDemo();
        ThreadDemo demo1 = new ThreadDemo();
        ThreadDemo demo2 = new ThreadDemo();
        ThreadDemo demo3 = new ThreadDemo();

        demo.start();
        demo1.start();
        demo2.start();
        demo3.start();

    }
}
