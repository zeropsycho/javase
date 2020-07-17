package javase.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端接收信息
 */
public class PicServer {

    public static void main(String[] args) throws IOException {
        // 建立服务端与客户端的通信
        ServerSocket serverSocket = new ServerSocket(10000);
        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();
        int temp = 0;
        // 获取客户端的信息
        FileOutputStream outputStream = new FileOutputStream("src/main/resources/img/iu_rep.jpg");
        while ((temp = inputStream.read()) != -1) {
            outputStream.write(temp);
        }
        socket.shutdownInput();

        // 给客户端回信
        OutputStream outputStream1 = socket.getOutputStream();
        outputStream1.write("上传成功！！！".getBytes());
        socket.shutdownOutput();
    }
}
