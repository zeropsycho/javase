
import javase.Whiletest;
import javase.abstracts.Cat;
import javase.carrental.Car;
import javase.peculiarity.Economic;

public class test {

    private Whiletest whiletest = new Whiletest();



    public void whiletest() {
//        whiletest.whiletest1();

    }

    public static void main(String[] args) {
//        show();
        Car car = new Car();

    }

    public static void show() {
//        Library library = new Library();
//        Library le = new Economic();
        Economic economic = new Economic();

//        le.serach(); // 调用子类的方法
        economic.serach(); // 调用子类中的方法

        Cat cat = new Cat();
        cat.name = "jjj";
        cat.print();
    }
}
