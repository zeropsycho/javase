package javase.Generic;

import java.util.ArrayList;

public class TestDemo {

    public static void main(String[] args) {
        Fullter fullter = new Fullter();

        // 实现类中指定类型
        /*Fluter<Fullter> fluter = new Fluter();
        fluter.test(fullter);
        fluter.test2(new String());*/

        // 编译时去泛型化操作
        ArrayList<String> a = new ArrayList<>();
        ArrayList<Integer> i = new ArrayList<>();

        Class cas = a.getClass();
        Class cai = i.getClass();
        if (cas.equals(cai)) {
            System.out.println(true);
        }
    }
}
