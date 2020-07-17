package javase.thread.consumption;

/**
 * 生产者
 */
public class Producer implements Runnable {

    private Dome dome;

    public Producer(Dome dome) {
        this.dome = dome;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                dome.set("伊利", "牛奶");
            } else {
                dome.set("华为", "mate4");
            }
        }
    }
}
