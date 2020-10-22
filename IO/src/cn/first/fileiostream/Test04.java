package cn.first.fileiostream;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author LiYun
 * @Date 2020/7/16 14:49
 * 以字节为单位把数据保存到文件中
 */
public class Test04 {
    public static void main(String[] args) throws IOException {
        //FileOutputStream fos = new FileOutputStream("d:/def.txt");
        //追加方式
        FileOutputStream fos = new FileOutputStream("d:/def.txt",true);

        fos.write(65);   //依次写一个字节，把65对应的字符A保存到文件中
        fos.write(66);
        fos.write(67);
        fos.write(68);
        //换行，在windows中，换行用\r\n两个字符
        fos.write('\r');
        fos.write('\n');
        //一次写一个字节数组
        byte[] bytes = "bjpower".getBytes();
        fos.write(bytes);  //把bytes数组中所有的字节保存到文件中
        //换行
        fos.write('\r');
        fos.write('\n');
        //字节数组中部分保存到文件中
        fos.write(bytes,0,2);
        fos.close();
    }
}
