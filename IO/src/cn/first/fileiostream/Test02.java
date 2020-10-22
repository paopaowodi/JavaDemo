package cn.first.fileiostream;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * @Author LiYun
 * @Date 2020/7/15 16:19
 * 一次读取一个字节数组 读取很多字节保存到字节数组中
 */
public class Test02 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("D:/abc.txt");

        byte[] bytes = new byte[4];

        int len = fis.read(bytes);
        System.out.println(len);
        System.out.println(Arrays.toString(bytes));

        fis.close();
    }
}
