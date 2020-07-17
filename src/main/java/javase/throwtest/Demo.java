package javase.throwtest;

/**
 * 异常处理类
 */
public class Demo {

    public void exception() throws ArithmeticException { // 抛出异常
        int i = 0;
        // 捕获异常处理
        try {
            int s = 5 / 0;
        } catch (Exception ex) {
            System.out.println("处理异常");
        } finally {
            System.out.println("不管如何都要执行");
        }
    }


}
