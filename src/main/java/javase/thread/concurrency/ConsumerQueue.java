package javase.thread.concurrency;

import java.util.concurrent.BlockingQueue;

/**
 * 消费者
 */
public class ConsumerQueue implements Runnable {

    private BlockingQueue<God> blockingQueue;

    public ConsumerQueue(BlockingQueue<God> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        God god = null;
        try {
            god = blockingQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 5; i++) {
            System.out.println("消费者：" + god.getBrand() + "消费了" + god.getName()); // 取数据
        }
    }
}
