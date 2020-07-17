package javase.file;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.regex.Matcher;

/**
 * 按指定字节的偏移量进行切割存储文件
 */
public class RandomAccessFileDemo {



    public static void main(String[] args) {

            File file = new File("src/main/resources/demo.txt");

            // 计算以1024为标准的偏移量
            int offset = 1024;
            // 定义文件长度
            long length = file.length();
            // 总快数
            int bo = (int) Math.ceil((length * 1.0 / offset)); // 向上取整
        // 定义偏移量长度
        int pos = 0;

            System.out.println("总块数：" + bo + ",文件总长度：" + length);
            int beginPo = 0; //其实位置
            // 实际位置
            int actualSize = (int) ((offset > length) ? length : offset);
            // 存储文件
            for (int i = 0; i < bo; i++) {
                beginPo = i * offset;
                if (i == bo - 1) {
                    actualSize = (int) length;
                } else {
                    actualSize = offset;
                    length -= actualSize;
                }
                System.out.println("起始位置：" + beginPo + "，读取大小：" + actualSize);
                read(pos, actualSize);
            }



    }

    public static void read(int pos, int actualSize) {

        File file = new File("src/main/resources/demo.txt");
        RandomAccessFile randomAccessFile = null;
        try {
            // r：读
            randomAccessFile = new RandomAccessFile(file, "r");
            randomAccessFile.seek(pos);
            byte[] bytes = new byte[1024];
            int length = 0;
            while ((length = randomAccessFile.read(bytes)) != -1) {
                if (length > actualSize) {
                    System.out.println(new String(bytes, 0, length));
                    actualSize -= length;
                } else {
                    System.out.println(new String(bytes, 0, length));
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
