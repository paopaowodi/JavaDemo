package cn.test;

import java.io.*;

/**
 * @Author LiYun
 * @Date 2020/9/13 17:31
 * 文件夹复制
 */
public class DirCopy {
    public static void main(String[] args) {

    }
    //普通文件的复制
    public static void FileCopy(String src,String dest){
        //打开流
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(src));
            bos = new BufferedOutputStream(new FileOutputStream(dest));
            //输入输出
            byte[] flush = new byte[1024];
            int len = -1;
            while((len = bis.read(flush)) != -1){
                bos.write(flush,0,len);
            }
            bos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭流
            try {
                if(bis != null){
                    bis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(bos != null){
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }
    //文件夹的复制
    public static void DirCopy(String src, String dest){
        //打开流通道
        File f1 = new File(src);
        File[] fs = f1.listFiles();
        File f2 = new File(dest);
        //判断是否为空
        if(! f2.exists()){
            f2.mkdirs();
        }
        for(File f:fs){
            if(f.isFile()){
                FileCopy(f.getPath(),dest+"\\"+f.getName());
            }else if(f.isDirectory()){
                DirCopy(f.getPath(),dest+"\\"+f.getName());
            }
        }
    }
}
