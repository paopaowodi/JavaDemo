package cn.second.IOStudy02;

import java.io.*;

/**
 * @Author LiYun
 * @Date 2020/8/4 15:17
 * 文件字节输入流 加入缓存流
 * 四个步骤：分段读取
 * 1、创建源
 * 2、选择流
 * 3、操作
 * 4、释放资源
 */
public class BufferedTest01 {
    public static void main(String[] args) {

    }
    public static void test1() {
        //1.创建源
        File src = new File("src/cn/second/IOstudy/abc.txt");
        //2.选择流
        InputStream is =null;
        try {
            is = new BufferedInputStream(new FileInputStream(src));
            //3、操作(分段读取)
            byte[] flush = new byte[1024];
            int len = -1; //接收长度
            while((len = is.read(flush)) != -1){
                //字节数组到字符串 (解码)
                String str = new String(flush,0,len);
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
           //4 释放资源b
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
