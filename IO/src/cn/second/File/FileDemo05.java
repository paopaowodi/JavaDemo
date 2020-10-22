package cn.second.File;

import java.io.File;

/**
 * @Author LiYun
 * @Date 2020/8/4 10:36
 * 其他信息
 *      length() 字节数，文件的长度
 */
public class FileDemo05 {
    public static void main(String[] args) {
        File src = new File("C:\\Users\\Dell\\Pictures\\Saved Pictures\\1.jpg");

        System.out.println("长度："+src.length());

        src = new File("C:\\Users\\Dell\\Pictures\\Saved Pictures");
        System.out.println("长度:"+ src.length());

        src = new File("C:\\Users\\Dell\\Pictures\\Saved");
        System.out.println("长度:"+src.length());
    }
}
