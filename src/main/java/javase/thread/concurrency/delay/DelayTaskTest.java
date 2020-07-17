package javase.thread.concurrency.delay;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayTaskTest {


    public static void main(String[] args) {
        DelayQueue<DelayTask> delayTasks = new DelayQueue<>();
        delayTasks.add(new DelayTask("1", 1000L, TimeUnit.MILLISECONDS));
        delayTasks.add(new DelayTask("2", 2000L, TimeUnit.MILLISECONDS));
        delayTasks.add(new DelayTask("3", 3000L, TimeUnit.MILLISECONDS));

        System.out.println("queue put done");

        // 取数据
        while (!delayTasks.isEmpty()) {
            try {
                DelayTask task = delayTasks.take();
                System.out.println(task.name + ":" +System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class DelayTask implements Delayed {
    public String name;
    private Long delayTime; // 延迟时间
    private TimeUnit unit; // 延迟单位
    private Long execteTime; // 执行时间

    public DelayTask(String name, Long delayTime, TimeUnit unit) {
        this.name = name;
        this.delayTime = delayTime;
        this.unit = unit;
        this.execteTime = System.currentTimeMillis() + unit.toMillis(delayTime);
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(execteTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    /**
     * 比较时间，前后执行
     * @param o
     * @return
     */
    @Override
    public int compareTo(Delayed o) {
        if (this.getDelay(TimeUnit.MILLISECONDS) > o.getDelay(TimeUnit.MILLISECONDS)) {
            return 1;
        } else if (this.getDelay(TimeUnit.MILLISECONDS) < o.getDelay(TimeUnit.MILLISECONDS)) {
            return -1;
        }
        return 0;
    }
}
