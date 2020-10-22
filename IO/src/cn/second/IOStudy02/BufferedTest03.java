package cn.second.IOStudy02;

import java.io.*;

/**
 * @Author LiYun
 * @Date 2020/8/4 15:17
 * 文件字符输入流 加入缓冲流
 * 四个步骤：分段读取
 * 1、创建源
 * 2、选择流
 * 3、操作
 * 4、释放资源
 */
public class BufferedTest03 {
    public static void main(String[] args) {
        //1.创建源
        File src = new File("src/cn/second/IOstudy/abc.txt");
        //2.选择流
        BufferedReader reader =null;
        try {
            reader = new BufferedReader( new FileReader(src));
            //3、操作(分段读取)
            String line = null;
            while((line = reader.readLine()) != null){
                //字节数组到字符串
                System.out.println(line);

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
