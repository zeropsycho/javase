package javase.socket.object;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 接受文件内容直接读取
 */
public class ObjectServer {

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        // 建立通信
        ServerSocket serverSocket = new ServerSocket(1000);
        Socket server = serverSocket.accept();

        // 获取序列化内容，
        InputStream inputStream = server.getInputStream();
        // 存储序列化的文件
        FileOutputStream fos = new FileOutputStream("src/main/resources/message2.objcet");
        int temp = 0;
        while ((temp = inputStream.read()) != -1) {
            fos.write(temp);
        }

        int temps = 0;
        byte[] bytes = new byte[1024];
        InputStream inputStream1 = new FileInputStream("src/main/resources/message2.objcet");

        int length = inputStream1.read(bytes);
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
//      System.out.println(new String(bytes1,0,length));

        ObjectInputStream ois = new ObjectInputStream(bais);

        Object o = ois.readObject();
        Objects os = (Objects) o;

        // 判断用户名密码是否正确
        // 返回客户端信息
        OutputStream outputStream = server.getOutputStream();
        if (os.getName().equals("用户名") && os.getId() == 123456) {
            outputStream.write("登录成功！！！".getBytes());
        } else {
            outputStream.write("登录失败，用户名或密码错误！".getBytes());
        }
        server.shutdownOutput();
    }
}
