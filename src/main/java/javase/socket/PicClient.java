package javase.socket;

import java.io.*;
import java.net.Socket;

/**
 * 传输图片
 */
public class PicClient {
    public static void main(String[] args) throws IOException {

        // 建立与服务端的通信
        Socket socket = new Socket("127.0.0.1", 10000);

        // 使用fileinputstream读取图片，然后将图片转换成字节流传输到服务端
        FileInputStream fileInputStream = new FileInputStream("src/main/resources/img/iu.jpg");
        int temp = 0;
        OutputStream outputStream = socket.getOutputStream();
        while((temp = fileInputStream.read()) != -1) {
            outputStream.write(temp);
        }
        socket.shutdownOutput();

        // 接受服务端信息
        InputStream inputStream = socket.getInputStream();
        byte[] bytes1 = new byte[1024];
        int length1 = inputStream.read(bytes1);
        System.out.println(new java.lang.String(bytes1,0,length1));
        socket.shutdownInput();
        outputStream.close();
        fileInputStream.close();
        socket.close();
    }
}
