package cn.second.File;

import java.io.File;

/**
 * @Author LiYun
 * @Date 2020/8/4 10:58
 * 打印子孙级目录和文件名称
 */
public class DirDemo03 {
    public static void main(String[] args) {
        File src = new File("D:\\learngit\\IO\\src\\cn");
        printName(src,0);
    }

    public static void printName(File src,int deep){
        for(int i = 0; i < deep;i++){
            System.out.print("-");
        }
        System.out.println(src.getName());
        if(null == src || ! src.exists()){
            return;
        }else if(src.isDirectory()){
            for(File s: src.listFiles()){
                printName(s,deep+1);
            }
        }
    }
}
