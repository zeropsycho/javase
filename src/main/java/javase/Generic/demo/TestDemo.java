package javase.Generic.demo;

import java.util.*;

public class TestDemo {

    private LinkedList<Employee> employeeLinkedList = new LinkedList();

    public static void main(String[] args) {
        Employee employee = new PM(1, "pm1", 25, "girl", "3");
        Employee employee2 = new PM(2, "pm2", 26, "girl", "3.5");

        Employee employee3 = new Programmer(3, "pm1", 23, "boy", "86");
        Employee employee4 = new Programmer(4, "pm1", 22, "boy", "90");

        // 定义ArrayList 实现查询
        ArrayList<Employee> employeeArrayList = new ArrayList<>(4);
        employeeArrayList.add(employee);
        employeeArrayList.add(employee2);
        employeeArrayList.add(employee3);
        employeeArrayList.add(employee4);
        try {
            new TestDemo().search(employeeArrayList, null);
        } catch (Exception ex) {
            System.out.println("处理" + ex);
        }

        // 定义LinkList 实现增删改
        TestDemo demo = new TestDemo();
        demo.employeeLinkedList.add(employee);
        demo.employeeLinkedList.add(employee2);
        demo.employeeLinkedList.add(employee3);
        demo.employeeLinkedList.add(employee4);
        new TestDemo().delete(1);
//        Employee employee5 = new Programmer(4, "pm1", 22, "boy", "90");

        // 定义TreeSet 实现排序
        TreeSet<Employee> employeeTreeSet = new TreeSet<Employee>();
        employeeTreeSet.add(employee);
        employeeTreeSet.add(employee2);
        employeeTreeSet.add(employee3);
        employeeTreeSet.add(employee4);

        for (Object o : employeeArrayList) {
            System.out.println(o.toString());
        }

    }

    /**
     * 查询
     *
     * @param arrayList
     * @return
     * @throws Exception
     */
    public StringBuffer search(ArrayList arrayList, String arrayName) throws Exception {
        if (arrayList == null) {
            throw new Exception("null");
        }

        StringBuffer buffer = new StringBuffer();
        StringBuffer matchValue = new StringBuffer();

        for (Object o : arrayList) {
            if (o.equals(arrayName)) {
                return matchValue.append(arrayName);
            }
            buffer.append(o);
        }
        return buffer;
    }

    /**
     * 删
     */
    public int delete(int id) {
        for (Iterator iterator = employeeLinkedList.listIterator(); iterator.hasNext(); ) {
            if (((Employee) iterator.next()).id == id) {
                iterator.remove();
                return 1;
            }
        }
        return 0;
    }

    /**
     * 添加
     *
     * @param id
     * @param name
     * @param age
     * @param gender
     * @param personType
     * @param type
     */
    public void add(int id, String name, int age, String gender, String personType, int type) {
        Employee employee = null;
        if (type == 1) {
            employee = new PM(id, name, age, gender, personType);
        } else if (type == 2) {
            employee = new Programmer(id, name, age, gender, personType);
        }
        employeeLinkedList.add(employee);
    }

}
