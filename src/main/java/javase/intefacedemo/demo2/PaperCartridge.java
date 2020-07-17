package javase.intefacedemo.demo2;

/**
 * 纸张生产厂家
 */
public class PaperCartridge implements Paper {
    @Override
    public void redA4() {
        System.out.println("poduce red A4");
    }

    @Override
    public void bludA3() {
        System.out.println("poduce blud A3");
    }
}
