package javase.thread.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;

public class QueueTest {

    public static void main(String[] args) {
        BlockingQueue<God> blockingQueue = new ArrayBlockingQueue<God>(5);
        ProducerQueue producerQueue = new ProducerQueue(blockingQueue);
        ConsumerQueue consumerQueue = new ConsumerQueue(blockingQueue);
        new Thread(producerQueue).start();
        new Thread(consumerQueue).start();
    }

}
