package javase.map;

import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * HashMap各种遍历方法，三种
 */
public class HashMaps {

    public static void main(String[] args) {
        HashMap<Integer, String> test = new HashMap<>(2);
        test.put(1,"one message");
        test.put(2,"two message");

        // 创建inputStream
        InputStream input = null;
        OutputStream out = null;
        try {
            input = new FileInputStream(new File("src/main/resources/demo.txt"));
            int length = 0;
            byte[] bytes = new byte[1024];
            while((length = input.read(bytes,5,5)) != -1) {
                System.out.println(byteToString(bytes));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
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

        // 遍历
        /*for (Integer o: test.keySet()) {
            System.out.println(o);
        }
        for (String o:test.values()) {
            System.out.println(o);
        }

        // two 通过k获取values
        for (Integer o: test.keySet()) {
            System.out.println(o + ":" + test.get(o));
        }

        // 同时获取map key，values 性能优先
        for (Map.Entry o : test.entrySet()) {
            System.out.println(o.getKey() + ":" + o.getValue());
        }*/

        // 删除操作 itertor
        /*Iterator<Map.Entry<Integer, String>> iterator = test.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            if (entry.getKey().equals(1)) {
                iterator.remove(); // 删除某个元素
            }
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        // lambdal
        test.forEach((key, values) -> {
            System.out.println(key + ":" + values);
        });*/

        HashMaps.treeMap();
    }

    public static void treeMap() {
        TreeMap<Integer, String> treeMap= new TreeMap<>();
        treeMap.put(1, "one Message");
        treeMap.put(2, "two message");
        treeMap.put(3, "three message");

        // 默认以key键作为排序 有序唯一，底层数据结构为红黑树
        for(Map.Entry<Integer, String> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    private static String byteToString(byte[] bytes) {
        if (null == bytes || bytes.length == 0) {
            return "";
        }
        String strContent = "";
        try {
            strContent = new String(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strContent;
    }
}
