package javase.Generic;

public class Fullter {

    /**
     * 测试泛型类数据
     * 类被实例化后，传入具体参数，对类的成员属性的类型和成员方法的参数类型和返回值进行替换
     *
     */
}

class Fluter<T> extends Fullter{

    /**
     * 泛型方法 少用
     */
    public <T> void test(T t) {
        System.out.println("与类中同种类型:" + t.getClass());
    }

    public <E> void test2 (E e) {
        System.out.println("专属方法类型" + e.getClass());
    }
}
