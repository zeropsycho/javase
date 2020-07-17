package javase.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器端
 */
public class Servers {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(10000);
            Socket socket = serverSocket.accept();

            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];

            int length = inputStream.read(bytes);
            System.out.println(new String(bytes, 0, length));

            // 发送客户端消息
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("服务器端收到！！！".getBytes());

            inputStream.close();
            outputStream.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
