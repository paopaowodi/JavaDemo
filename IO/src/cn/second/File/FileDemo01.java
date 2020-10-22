package cn.second.File;

import java.io.File;

/**
 * @Author LiYun
 * @Date 2020/8/4 10:03
 * @Version 1.0
 */
public class FileDemo01 {
    public static void main(String[] args) {
        String path = "C:/Users/Dell/Pictures/Saved Pictures/1.jpg";

        //构建file对象
        File src = new File(path);
        System.out.println(src.length());
        //2.
        src = new File("C:/Users/Dell/Pictures/Saved Pictures/1.jpg");
        System.out.println(src.length());
        //3.
        src = new File(new File("C:/Users/Dell/Pictures/Saved Pictures"),"1.jpg");
        System.out.println(src.length());
    }
}
