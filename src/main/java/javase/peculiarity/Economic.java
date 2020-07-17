package javase.peculiarity;

/**
 * 经济类
 * 1
 */
public class Economic extends Library {

    public Economic () {
        super("d");
        System.out.println("economic 构造方法");
    }

    @Override
    public void serach() {
        System.out.println("serach Econmoic");
        super.serach();
    }



}