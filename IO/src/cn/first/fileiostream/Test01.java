package cn.first.fileiostream;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Author LiYun
 * @Date 2020/7/15 16:02
 * 读写文件步骤 以字节为单位读取文件内容
 */
public class Test01 {
    public static void main(String[] args) throws IOException {
        //1)在当前程序与指定文件之间建立流通道
        FileInputStream fis = new FileInputStream("d:/abc.txt");

        //2)读写文件内容

       int cc = fis.read();
       while(cc != -1){
           System.out.print((char)cc);
           cc = fis.read();
       }

        //3)关闭流通道

        fis.close();
    }
}
