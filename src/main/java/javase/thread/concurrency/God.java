package javase.thread.concurrency;

public class God {

    // 品牌
    private String brand;
    // name
    private String name;

    public God () {}

    public God(String brand, String name) {
        this.brand = brand;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

}
