package cn.DirCopy;

import java.io.*;

/**
 * @Author LiYun
 * @Date 2020/9/11 20:39
 * @Version 1.0
 */
public class DirrectoryCopy {
    public static void main(String[] args) {

    }
    //文件复制
    private static void FileCopy(String src,String des){
        //打开输入输出流
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(src));
            bos = new BufferedOutputStream(new FileOutputStream(des));

            //读写操作
            byte[] flush = new byte[1024];
            int len = -1;
            while((len =bis.read(flush)) != -1){
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
                if(bos != null){
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(bis != null){
                    bis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
    //复制操作
    private static void DirCopy(String src, String des){
        //打开文件通道
        File fileSource = new File(src);
        File[] fs = fileSource.listFiles();
        File file2 = new File(des);
        //判断目标地址是否存在
        if(! file2.exists()){
            file2.mkdirs();
        }
        for(File f:fs){
            //如果是文件，则进行文件复制操作
            if(f.isFile()){
                FileCopy(f.getPath(),des+"\\"+f.getName());
                //如果是文件夹，则递归
            }else if(f.isDirectory()){
                DirCopy(f.getPath(),des+"\\"+f.getName());
            }
        }
    }
}
