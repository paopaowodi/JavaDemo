package cn.first.object;

import java.io.*;

/**
 * @Author LiYun
 * @Date 2020/7/17 9:17
 * 对象反序列化，把对象从文件中读取出来
 */
public class Test02 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        InputStream in = new FileInputStream("d:/obj.txt");
        ObjectInputStream ois = new ObjectInputStream(in);
        //从文件中读取一个对象,obj是Object类型，但是引用的是Person对象
        Object obj = ois.readObject();

        System.out.println(obj);
        ois.close();
    }
}
