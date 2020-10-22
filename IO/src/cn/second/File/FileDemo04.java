package cn.second.File;

import java.io.File;

/**
 * @Author LiYun
 * @Date 2020/8/4 10:23
 * 文件状态
 * 1.不存在：exists
 * 2.存在：
 *      文件 isFile
 *      文件夹：isDirectory
 */
public class FileDemo04 {
    public static void main(String[] args) {
        File src = new File("study/IO.png");
        System.out.println(src.getAbsolutePath());
        System.out.println("是否存在:"+ src.exists());
        System.out.println("是否文件："+ src.isFile());
        System.out.println("是否文件夹："+src.isDirectory());

        src = new File("IO.png");
        System.out.println("-----------------");
        System.out.println("是否存在:"+ src.exists());
        System.out.println("是否文件："+ src.isFile());
        System.out.println("是否文件夹："+src.isDirectory());

        src = new File("C:/Users/Dell/Pictures/Saved Pictures");
        System.out.println("-----------------");
        System.out.println("是否存在:"+ src.exists());
        System.out.println("是否文件："+ src.isFile());
        System.out.println("是否文件夹："+src.isDirectory());

    }
}
