package javase.file;

import java.io.*;

/**
 * buffreader字符串
 */
public class BufferReaderDemo {

    public static void main(String[] args) {
        out();
        input();
    }

    public static void input() {
        // 创建buffer流
        BufferedReader bufferedReader = null;

        try {
            String are = null;
            bufferedReader = new BufferedReader(new FileReader("src/main/resources/demoRep.txt"));
            while ((are = bufferedReader.readLine()) != null) {
                System.out.println(are);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void out() {
        // 输出流
        BufferedWriter bufferedWriter = null;

        try {
            bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/demoRep.txt"));
            bufferedWriter.append("wwww");
            bufferedWriter.newLine();
            bufferedWriter.append("baidu");
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
