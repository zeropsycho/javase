package javase.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * socket服务端
 */
public class Client {

    public static void main(String[] args) {
        // 创建socket客户端
        try {
            Socket socket = new Socket("127.0.0.1", 10000);
            // 发送信息流
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("hello,my is client".getBytes());

            // 接受服务端的信息
            InputStream inputStream = socket.getInputStream();

            byte[] bytes = new byte[1024];
            int length = inputStream.read(bytes);
            System.out.println(new String(bytes, 0, length));

            outputStream.close();
            inputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
