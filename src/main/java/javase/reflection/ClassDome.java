package javase.reflection;

import javase.socket.object.Objects;

import java.lang.reflect.Field;

public class ClassDome {

    public static void main(String[] args) {
        // 获取类对象
        Class objectsClass = Objects.class;
        // 获取类属性
        Field[] declaredFields = objectsClass.getDeclaredFields();
        for (Object o : declaredFields) {

            System.out.println(o);
        }
    }
}
