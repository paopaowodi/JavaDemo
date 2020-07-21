package cn.ly.print;

import java.io.*;

/**
 * @Author LiYun
 * @Date 2020/7/17 10:02
 * PrintWriter  以字符为单位的打印流
 */
public class Test02 {
    public static void main(String[] args) throws IOException {

        PrintWriter pw = new PrintWriter(new FileWriter("d:def.txt"));
        pw.print("字符打印流");

        try {
            FileInputStream fis = new FileInputStream("d:abcd.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
