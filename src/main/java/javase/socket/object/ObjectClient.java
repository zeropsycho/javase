package javase.socket.object;

import java.io.*;
import java.net.Socket;

/**
 * 客户端object序列化
 */
public class ObjectClient {

    public static void main(String[] args) throws IOException {
        // 建立通信
        Socket client = new Socket("127.0.0.1", 1000);
        FileOutputStream fos = new FileOutputStream("src/main/resources/message.objcet");
        // 序列化对象
        ObjectOutputStream ois = new ObjectOutputStream(fos);
        ois.writeObject(new Objects("用户名", 123456));

        // 上传序列化的结果
        FileInputStream fis = new FileInputStream("src/main/resources/message.objcet");

        OutputStream outputStream = client.getOutputStream();
        int temp = 0;
        while ((temp = fis.read()) != -1) {
            outputStream.write(temp);
        }
        client.shutdownOutput();

        // 接受服务端信息
        byte[] bytes = new byte[1024];
        InputStream inputStream = client.getInputStream();
        int length = inputStream.read(bytes);
        System.out.println(new String(bytes,0,length));
        client.shutdownInput();

        inputStream.close();
        outputStream.close();
        client.close();
    }
}
