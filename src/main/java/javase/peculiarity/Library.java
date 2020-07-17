package javase.peculiarity;

/**
 * 图书馆类
 */
public class Library {

    private String administrator;
    /**
     * 公用属性 方法
     */
    public Library() {
        System.out.println("library 构造方法");
    }
    public Library(String c) {
        System.out.println(c);
    }
    /*private Library() {
        System.out.println("library 构造方法");
    }*/

    /**
     * serach 图书
     */
    public void serach() {
        System.out.println("serach-library");
    }

}
