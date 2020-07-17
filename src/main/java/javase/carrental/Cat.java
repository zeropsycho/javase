package javase.carrental;

/**
 * 猫类
 */
public class Cat extends Pet {

    @Override
    public void show() {
        System.out.println("cat");
    }

    public Pet eat(int type) {
        if (type == 1) {
            return new Cat();
        }
        return new Pet();
    }
}
