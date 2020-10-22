package cn.study.test.tetest;

import java.io.*;

/**
 * @Author LiYun
 * @Date 2020/9/7 18:25
 * 文件夹的拷贝
 */
public class DirCopy {
    public static void main(String[] args) throws Exception {
        copy("D:\\copy","D:/fuzi1");
        System.out.println("拷贝完成");

    }
    //复制方法

    public static void copy(String src, String des)throws Exception{
        File file1 = new File(src);
        File[] fs = file1.listFiles();
        File file2 = new File(des);
        if(!file2.exists()){
            file2.mkdirs();
        }
        for(File f: fs){
            if(f.isFile()){
                fileCopy(f.getPath(),des+"\\"+f.getName());
            }else if(f.isDirectory()){
                copy(f.getPath(),des+"\\"+f.getName());
            }
        }
    }

    //普通的文件复制
    private static void fileCopy(String src,String des) throws Exception{
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(des));
        int len = -1;
        byte[] flush = new byte[1024];
        while((len = bis.read(flush) )!= -1){
            bos.write(flush,0,len);
        }
        bis.close();
        bos.close();
    }
}
