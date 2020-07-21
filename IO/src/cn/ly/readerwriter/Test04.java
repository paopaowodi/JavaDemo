package cn.ly.readerwriter;

import java.io.*;

/**
 * @Author LiYun
 * @Date 2020/7/17 8:37
 * 字符缓冲流
 */
public class Test04 {
    public static void main(String[] args) throws IOException {
      //  m1();
        //m2(); //使用BufferedWriter保存文本到文件
        m3(); //从键盘输入文本，把这些文本保存到文件
    }

    private static void m3() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("d:/xyz.txt"));
        //使用BufferedReader对键盘输入流缓冲
        //System.in 标准输入设备，即键盘
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine() ;
        while(line.length() >0){
            bw.write(line);
            bw.newLine();
            line = br.readLine();
        }

        br.close();
        bw.close();

    }

    private static void m2() throws IOException {

        Writer out = new FileWriter("d:/abc.txt",true);
        BufferedWriter bw = new BufferedWriter(out);

        bw.write("\r\n快乐的一只小青蛙");
        bw.flush();

        bw.close(); //关闭时也会清空缓冲区
    }

    private static void m1() throws IOException {

        Reader in = new FileReader("d:/abc.txt");
        BufferedReader br = new BufferedReader(in);

        String line = br.readLine();
        while(line != null){
            System.out.println( line);
            line = br.readLine();
        }

        br.close();       //包装流关闭，被包装流也会自动关闭

    }
}
