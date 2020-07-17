package javase.inner;

public class Demo {

    // 外部属性
    private String name;
    public int id = 0;
    public void show() {
        System.out.println(new Inner1().name);
    }

    class Inner1 {
        String name = "zhangsan";
        public void show() {


            System.out.println("inner class");
            System.out.println(name);
            System.out.println(Demo.this.id);
        }
    }
}
