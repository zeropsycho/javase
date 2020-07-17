package javase.carrental;

import java.util.Scanner;

/**
 * 客户选择租赁方式
 */
public class Operating {

    public static void main(String[] args) throws Exception {
        Car car = new Car();
        double carRents = 0.0;
        String carX = "";
        int day = 0;


        Scanner scanner = new Scanner(System.in);

        System.out.println("欢迎进入XX租车软件");
        System.out.println("1.查询车型/n2.选择车型:");
        int ints = scanner.nextInt();
        switch (ints) {
            case 1 :
                for (int i = 0; i < car.findCar().length; i++) {
                    if (i != 0 && i%2 == 0) {
                        System.out.println(car.findCar()[i]);
                    } else {
                        System.out.printf(car.findCar()[i]);
                    }

                }
                break;
            case 2:
                System.out.println("请输入汽车编号");
                int numInt = scanner.nextInt();
                System.out.println("请输入租车天数");
                day = scanner.nextInt();
                String[] carRent = car.indexCar(numInt);
                carX = carRent[0];
                double carMo = Double.valueOf(carRent[1]);
                carRents = car.rent(day, carMo);
            default:
                System.out.println("在输入一遍");
        }
        System.out.println("你选择的车型：" + carX);
        System.out.println("一共出租天数：" + day);
        System.out.println("应付金额：" + carRents);
        System.out.println("祝你旅途愉快！！！!");


        // 通过形参
        Pet cat = new Cat();
        cat.show();

        // 通过返回参数
        Pet cats = ((Cat) cat).eat(1);
        if (cats instanceof Cat) {
            System.out.println("猫吃东西");
        }
    }
}
