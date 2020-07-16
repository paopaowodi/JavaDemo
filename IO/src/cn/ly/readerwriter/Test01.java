package cn.ly.readerwriter;

import com.sun.org.apache.xpath.internal.operations.String;

import java.io.FileReader;
import java.io.IOException;

/**
 * @Author LiYun
 * @Date 2020/7/16 15:32
 * 以字符为单位读写文件内容，只能读写纯文本文件
 */
public class Test01 {
    public static void main(String[] args)  {
        //m1();//通过FileReader读取文件内容，一次读取一个字符
        m2(); //文本文件内容，一次读取一个字符数组，异常处理，自动关闭
    }

    private static void m2() {
        try(
                FileReader fr = new FileReader("d:/abc.txt");
                ){
            char [] contents = new char[1024];
            int len = fr.read(contents);
            System.out.println(len);
            while(len != -1){
                //System.out.print(new String(contents,0,len));
                len = fr.read(contents);

            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private static void m1() throws IOException {
        //建立流通道
        FileReader fr = new FileReader("d:/abc.txt");

        //一次读取一个字符，返回字符的码值，读到文件末尾返回-1
        int cc = fr.read();
        while(cc != -1){
            System.out.println((char)cc);
            cc = fr.read();
        }

        fr.close();

    }
}
