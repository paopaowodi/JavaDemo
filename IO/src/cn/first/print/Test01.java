package cn.first.print;

import java.io.*;

/**
 * @Author LiYun
 * @Date 2020/7/17 9:54
 * PrintStream 打印字节流
 */
public class Test01 {
    public static void main(String[] args) throws FileNotFoundException {
       //1)
        OutputStream out = new FileOutputStream("d:/dog.txt");
        PrintStream pStream = new PrintStream(out);
        System.out.print("hello");
        System.out.println(" world");

        //2)System类的out成员就是PrintStream类型的打印流
        //System.out默认系统的标准输出设备是显示器
        System.out.println("默认在显示器上打印信息");
        //修改打印方向
        System.setOut(pStream);
        System.out.println("这一行信息打印到pStream的dog文件");

        //3）把异常信息保存到日志文件中
        try {
            FileInputStream fis = new FileInputStream("d:/abcd.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace(pStream);
        }

        pStream.close();
    }
}
