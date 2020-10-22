package cn.second.File;

import java.io.File;

/**
 * @Author LiYun
 * @Date 2020/8/4 11:06
 * 统计文件夹大小
 */
public class DirDemo04 {
    public static void main(String[] args) {
        File src = new File("D:\\learngit\\IO\\src\\cn");
        count(src);
        System.out.println(len);
    }
    private static long len = 0;

    public static void count(File src){
        //获取大小
        if(null != src && src.exists()){
            if(src.isFile()){
                len += src.length();
            }else{
                for(File s: src.listFiles()){
                    count(s);
                }
            }
        }
    }
}
