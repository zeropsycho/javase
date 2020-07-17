package javase.inner;

public class TestDemo {

    public static void main(String[] args) {
//        Demo.Inner1 inner1 = new Demo.Inner1(); //static fangshi
        Demo.Inner1 inner11 = new Demo().new Inner1();  // 非静态inner执行方式

        System.out.println(new TestDemo().v());

    }
    public int v () {
        int i = 0;
        try {
            System.out.println("try代码块");
            return i+1;
        } catch (Exception e) {
            System.out.println("Exception");
        } finally {
            System.out.println("finally");
            i = i+2;
        }

        return i;
    }
}
