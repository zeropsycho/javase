package javase.intefacedemo.demo2;

/**
 * 墨水厂家
 */
public class InkMerchant implements InkCartridge {
    @Override
    public void blakInk(String ink) {
        System.out.println("Produce blakInk");
    }

    @Override
    public void colorInk(String ink) {
        System.out.println("Produce colorInk");
    }
}
