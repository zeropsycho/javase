package javase.thread.consumption;

public class Dome {

    // 品牌
    private String Brand;
    // name
    private String name;

    private Boolean flag = false;

    public Dome() {

    }


    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized void set(String brand, String name) {
        if (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.setBrand(brand);
        this.setName(name);
        System.out.println("生产者：" + this.getBrand() + ",生产了" + this.getName());
        flag = true;
        notify();
    }

    public synchronized void get() {
        if (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("消费者：" + this.getBrand() + "消费了" + this.getName());
        flag = false;
        notify();
    }
}
