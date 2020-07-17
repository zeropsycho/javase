package javase.thread.consumption;

/**
 * 消费者
 */
public class Consumer implements Runnable {

    private Dome dome;

    public Consumer(Dome dome) {
        this.dome = dome;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            dome.get();
        }
    }
}
