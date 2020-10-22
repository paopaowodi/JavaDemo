package cn.second.File;

import java.io.File;

/**
 * @Author LiYun
 * @Date 2020/8/4 10:18
 * @Version 1.0
 */
public class FileDemo03 {
    public static void main(String[] args) {
        File src = new File("C:/Users/Dell/Pictures/Saved Pictures/1.jpg");
        //基本信息
        System.out.println("名称:"+src.getName());
        System.out.println("路径:"+src.getPath());  //相对或绝对
        System.out.println("绝对路径"+src.getAbsolutePath()); //绝对
        System.out.println("父路径"+src.getParent()); //上路径 返回Null
        System.out.println("父对象"+src.getParentFile().getName());
    }
}
