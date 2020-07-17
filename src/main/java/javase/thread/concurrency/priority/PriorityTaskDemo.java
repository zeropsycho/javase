package javase.thread.concurrency.priority;

import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityTaskDemo {

    public static void main(String[] args) {
        PriorityBlockingQueue<PriorityTask> priorityTasks = new PriorityBlockingQueue<>();
        priorityTasks.add(new PriorityTask(1, "1"));
        priorityTasks.add(new PriorityTask(2, "2"));

        try {
            System.out.println(priorityTasks.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class PriorityTask implements Comparable<PriorityTask> {
    private int id;
    private String name;

    public PriorityTask(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 比较优先级
    @Override
    public int compareTo(PriorityTask o) {
        return this.id > o.id ? 1 :(this.id < o.id ? -1 : 0);
    }

    @Override
    public String toString() {
        return "id : " + id + "name : " + name;
    }
}