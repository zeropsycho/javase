package javase.Generic.demo;

import java.util.Comparator;

/**
 * 产品经理工作年限
 */
public class PM extends Employee {

    public String workOfYear; //工作年限


    public PM(int id, String name, int age, String gender, String workOfYear) {
        super(id, name, age, gender);
        this.workOfYear = workOfYear;
    }

    public void demand() {
        System.out.println("发布需求");
    }
}
