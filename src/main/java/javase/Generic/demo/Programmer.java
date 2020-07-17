package javase.Generic.demo;

import java.util.Comparator;

/**
 * 程序员
 */
public class Programmer extends Employee {

    public String popularity;

    public Programmer(int id, String name, int age, String gender, String popularity) {
        super(id, name, age, gender);
        this.popularity = popularity;
    }

    public void Programming () {
        System.out.println("编写程序");
    }
}
