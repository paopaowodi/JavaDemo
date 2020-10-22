package cn.second.ly;

import java.io.*;

/**
 * @Author LiYun
 * @Date 2020/8/4 15:34
 * @Version 1.0
 */
public class IOTest01 {
    public static void main(String[] args) {
        File src = new File("D:/learngit/IO/src/cn/second/ly/123.txt");
        int temp;
        InputStream is = null;
        try {
            is = new FileInputStream(src);
            while((temp = is.read()) != -1){
                System.out.print((char)temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
