package cn.second.IOstudy01;

import java.io.*;

/**
 * @Author LiYun
 * @Date 2020/8/4 15:17
 * 文件字符输入流
 * 四个步骤：分段读取
 * 1、创建源
 * 2、选择流
 * 3、操作
 * 4、释放资源
 */
public class IOTest05 {
    public static void main(String[] args) {
        //1.创建源
        File src = new File("src/cn/second/IOstudy/abc.txt");
        //2.选择流
        Reader reader =null;
        try {
            reader = new FileReader(src);
            //3、操作(分段读取)
            char[] flush = new char[1024];
            int len = -1; //接收长度
            while((len = reader.read(flush)) != -1){
                //字节数组到字符串
                String str = new String(flush,0,len);
                System.out.println(str);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
           //4 释放资源
            try {
                if(null != reader){
                reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
