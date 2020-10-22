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
public class IOTest02 {
    public static void main(String[] args) {
        //1.创建源
        File src = new File("src/cn/second/IOstudy/abc.txt");
        //2.选择流
        InputStream is =null;
        try {
            is = new FileInputStream(src);
            //3、操作
            int temp;
            while((temp = is.read()) != -1){
                System.out.println((char)temp);
            }
            is.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
           //4 释放资源
            try {
                if(null != is){
                is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
