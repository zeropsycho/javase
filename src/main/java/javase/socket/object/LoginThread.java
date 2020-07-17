package javase.socket.object;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * 客户端使用多线程完成
 */
public class LoginThread implements Runnable {

    private ServerSocket serverSocket;

    public LoginThread(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    @Override
    public void run() {
        Socket socket = null;

        // 获取数据
        ObjectInputStream objectInputStream = null;
        OutputStream outputStream = null;
        while (true) {
            try {
                socket = serverSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                objectInputStream = new ObjectInputStream(socket.getInputStream());
                // 存储数据
                Objects objects = (Objects) objectInputStream.readObject();
                String str = "";
                if (objects.getName().equals("user") && objects.getId() == 123456) {
                    str = "登录成功！欢迎" + objects.getName();
                } else {
                    str = "登录失败！！！";
                }
                socket.shutdownInput();

                outputStream = socket.getOutputStream();
                outputStream.write(str.getBytes());
                socket.shutdownOutput();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    outputStream.close();
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
class LoginClient {
    public static void main(String[] args) throws IOException {

        ObjectOutputStream objectOutputStream = null;
        InputStream inputStream = null;
        Scanner scanner = new Scanner(System.in);

        Objects objects = new Objects();
        Socket socket = null;
        while (true) {
            try {
                socket = new Socket("127.0.0.1", 10000);
                // 可持续输入账户密码
                System.out.println("请输入账户：");
                String name = scanner.next();
                objects.setName(name);
                System.out.println("请输入密码：");
                int id = scanner.nextInt();
                objects.setId(id);

                // 传输数据
                objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                objectOutputStream.writeObject(objects);
                socket.shutdownOutput();

                // 接受服务信息
                byte[] bytes = new byte[1024];
                inputStream = socket.getInputStream();
                int length = inputStream.read(bytes);
                System.out.println(new String(bytes, 0, length));
                socket.shutdownInput();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                objectOutputStream.close();
                inputStream.close();
            }
        }
    }
}
