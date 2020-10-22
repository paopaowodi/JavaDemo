package cn.second.File;

import java.io.File;

/**
 * @Author LiYun
 * @Date 2020/8/4 10:48
 * 创建目录
 * 1.mkdir():必须确保上级目录存在。不存在创建失败
 * 2.mkdirs(): 上级目录可以不存在
 */
public class DirDemo01 {
    public static void main(String[] args) {
        File dir = new File("D:\\learngit\\IO\\src\\cn\\study\\test\\tetest\\2");
        //创建目录
        boolean flag = dir.mkdirs();
        System.out.println(flag);
    }
}
