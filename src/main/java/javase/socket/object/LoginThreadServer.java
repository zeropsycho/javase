package javase.socket.object;

import java.io.IOException;
import java.net.ServerSocket;

public class LoginThreadServer {

    public static void main(String[] args) throws IOException {

//        客户端循环传输数据登录
        ServerSocket serverSocket = new ServerSocket(10000);

        LoginThread loginThread = new LoginThread(serverSocket);
        Thread thread = new Thread(loginThread);
        thread.start();
    }

}
