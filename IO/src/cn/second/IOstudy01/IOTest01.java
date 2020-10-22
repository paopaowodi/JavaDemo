package cn.second.IOstudy01;

import java.io.*;

/**
 * @Author LiYun
 * @Date 2020/8/4 15:17
 * 第一个程序
 * 1、创建源
 * 2、选择流
 * 3、操作
 * 4、释放资源
 */
public class IOTest01 {
    public static void main(String[] args) {
        //1.创建源
        File src = new File("src/cn/second/IOstudy/abc.txt");
        //2.选择流
        try {
            InputStream is = new FileInputStream(src);
            //3、操作
            int data1 = is.read();//第一个数据 h
            int data2 = is.read();
            int data3 = is.read();
            System.out.println((char) data1);
            System.out.println((char) data2);
            System.out.println((char) data3);
            is.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
