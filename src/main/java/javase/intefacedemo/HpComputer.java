package javase.intefacedemo;

/**
 * hp电脑。。。。
 */
public class HpComputer implements Computer {
    // 重写
    @Override
    public void gamePlay() {

    }

    @Override
    public void read() {

    }


    public String reads() {
        return "hh";
    }
    // 重载
    public String reads(int i) {
        return "hh";
    }
}
