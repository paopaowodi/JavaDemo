package cn.second.File;

import java.io.File;

/**
 * @Author LiYun
 * @Date 2020/8/4 10:53
 * 列出下一级
 * 1、list()：列出下级名称
 * 2.listFiles()：列出下级file对象
 *
 * 列出所有盘符 listRoots()
 */
public class DirDemo02 {
    public static void main(String[] args) {
        File dir = new File("D:\\learngit\\IO\\src\\cn");

        //列出下级名称List
        String[] subNames = dir.list();
        for(String s:subNames){
            System.out.println(s);
        }

        //下级对象 listFiles()
        File[] subFiles = dir.listFiles();
        for(File s :subFiles){
            System.out.println(s.getAbsolutePath());
        }
    }
}
