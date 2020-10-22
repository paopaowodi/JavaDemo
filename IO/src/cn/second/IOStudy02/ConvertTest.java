package cn.second.IOStudy02;

import java.io.*;

/**
 * @Author LiYun
 * @Date 2020/8/5 14:59
 * 转换流： InputStreamReader OutputStreamWriter
 * 1、以字符流的形式操作字节流（纯文本的）
 * 2、可以指定字符集
 */
public class ConvertTest {
    public static void main(String[] args) {
        //操作 System.in 和 System.out
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            writer = new BufferedWriter(new OutputStreamWriter(System.out));
            //循环获取键盘的输入(exit退出)，输出此内容
            String msg = "";
            while (!msg.equals("exit")) {
                msg = reader.readLine();
                writer.write(msg);
                writer.newLine();
                writer.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}