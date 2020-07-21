package cn.ly.file;

import java.io.File;
import java.io.IOException;

/**
 * @Author LiYun
 * @Date 2020/7/17 10:07
 * 创建 File对象
 */
public class Test01 {
    public static void main(String[] args) throws IOException {
        File f1 = new File("d:/java");
        f1.mkdir();             //创建文件夹

        File f2 = new File("d:/java/sub1");
        f2.mkdir();

        File f3 = new File("d:/java","sub2");
        f3.createNewFile();         //创建文件

        File f4 = new File(f2,"sub3");
        f4.createNewFile();
    }
}
