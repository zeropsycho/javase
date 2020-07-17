package javase.thread.concurrency.priority;

import java.util.Random;
import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueTsak {

    public static void main(String[] args) {
        SynchronousQueue<SynchronousTask> queue = new SynchronousQueue<>();
        SynchronousTask synchronousTask = new SynchronousTask(queue);
        SynchronousTaskTwo synchronousTaskTwo = new SynchronousTaskTwo(queue);
        Thread thread = new Thread(synchronousTask);
        Thread thread1 = new Thread(synchronousTaskTwo);
        thread.start();
        thread1.start();
    }
}

class SynchronousTask implements Runnable {

    private SynchronousQueue<Integer> synchronousTasks;
    public String name;
    public int index;

    public SynchronousTask() {
    }

    public SynchronousTask(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public SynchronousTask (SynchronousQueue task) {
        this.synchronousTasks = task;
    }

    @Override
    public void run() {
        int i = 0;
        try {
            int read = new Random().nextInt(1000);
            synchronousTasks.put(read);
            System.out.println("生产者：" + read);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("是否为空:" + synchronousTasks.isEmpty());
    }
}

class SynchronousTaskTwo implements Runnable {

    private SynchronousQueue synchronousTaskTwos;
    public SynchronousTaskTwo(SynchronousQueue synchronousTaskTwos) {
        this.synchronousTaskTwos = synchronousTaskTwos;
    }

    @Override
    public void run() {

        // 取数据
        try {
            System.out.println("消费元素：" + synchronousTaskTwos.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("================");
    }
}