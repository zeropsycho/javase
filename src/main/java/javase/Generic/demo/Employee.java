package javase.Generic.demo;

import java.util.Comparator;

public class Employee implements Comparable{


    @Override
    public int compareTo(Object o) {
        if (o instanceof Employee) {
            if (this.id < ((Employee)o).id) {
                return -1;
            } else if (this.id > ((Employee)o).id) {
                return 1;
            }
        }
        return 0;
    }

    enum EmployeeEnum {
        id (1),
        name ("zs"),
        age (20),
        gender ("男");

        EmployeeEnum(int i) {}
        EmployeeEnum(String i) {}
    }

    public int id;
    public String name;
    public int age;
    public String gender;

    public Employee(){}

    public Employee(int id, String name, int age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

}
