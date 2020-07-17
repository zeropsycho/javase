package javase.thread.concurrency;

import java.util.concurrent.BlockingQueue;

/**
 * 生产者
 */
public class ProducerQueue implements Runnable {

    private BlockingQueue<God> blockingQueue;

    public ProducerQueue(BlockingQueue<God> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        God god = null;
        for (int i = 0; i < 5; i++) {
            if (i % 2 == 0) {
                god = new God("华为", "mate");
            } else {
                god = new God("伊利", "牛奶");
            }

            try {
                blockingQueue.put(god); // 生产
                System.out.println(god.getBrand() + "生产了" + god.getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
