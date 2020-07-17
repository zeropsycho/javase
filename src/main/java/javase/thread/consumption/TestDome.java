package javase.thread.consumption;

public class TestDome {

    public static void main(String[] args) {
        Dome dome = new Dome();
        Producer producer = new Producer(dome);
        Consumer consumer = new Consumer(dome);
        Thread thread = new Thread(producer);
        Thread thread1 = new Thread(consumer);

        thread.start();
        thread1.start();
    }
}
