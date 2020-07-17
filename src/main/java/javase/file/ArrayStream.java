package javase.file;

import org.omg.PortableInterceptor.ObjectReferenceFactoryHelper;

import java.io.*;

public class ArrayStream {

    public static void main(String[] args) {
        out();
        input();

    }

    public static void input() {
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;

        try {
            fileInputStream = new FileInputStream("src/main/resources/demo3.txt");
            objectInputStream = new ObjectInputStream(fileInputStream);
            Object object = objectInputStream.readObject();

            if (object instanceof TestDemo) {
                TestDemo t = (TestDemo) object;
                System.out.println(t);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void out() {
        ObjectOutputStream objectOutputStream = null;
        FileOutputStream fileOutputStream = null;
        try {

            fileOutputStream = new FileOutputStream("src/main/resources/demo3.txt");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(new TestDemo());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class TestDemo implements Serializable {

    private int id;
    private String name;

    @Override
    public String toString() {
        return "TestDemo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
