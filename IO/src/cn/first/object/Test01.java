package cn.first.object;

import java.io.*;

/**
 * @Author LiYun
 * @Date 2020/7/17 9:14
 * @Version 1.0
 */
public class Test01 {
    public static void main(String[] args) throws IOException {
        Person p1 = new Person("vivi",19);
        //对象序列化，把p1对象保存到文件中
        OutputStream out = new FileOutputStream("d:/obj.txt");
        ObjectOutputStream oos = new ObjectOutputStream(out);

        oos.writeObject(p1);
        oos.close();
    }
}
