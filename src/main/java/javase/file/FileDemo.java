package javase.file;

import java.io.*;

/**
 * 输入流，输出流
 * inputStream读取数据
 * outputStream写数据
 */
public class FileDemo {

    public static void main(String[] args) {
        // 创建inputStream
        InputStream input = null;
        OutputStream out = null;
        OutputStreamWriter writer = null;
        InputStreamReader isr = null;
        try {
            input = new FileInputStream(new File("src/main/resources/demo.txt"));
            isr = new InputStreamReader(input, "utf-8");

            /*byte[] bytes = new byte[1024];
            while((length = input.read(bytes,5,5)) != -1) {
                System.out.println(new String(bytes, "UTF-8"));
            }*/
            char[] chars = new char[1024];
            int length = isr.read(chars);
            System.out.println(new String(chars,0,length));

            out = new FileOutputStream(new File("src/main/resources/demoRep.txt"));
            writer = new OutputStreamWriter(out, "UTF-8");
            writer.write(chars);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
                isr.close();
                input.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 读取文本中的内容

        // 创建outputStream

        // 将内容写入到文本中

        // 关闭流
    }
}
