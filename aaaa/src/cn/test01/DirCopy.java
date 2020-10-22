package cn.test01;

import java.io.*;

/**
 * @Author LiYun
 * @Date 2020/9/13 18:59
 *
 */
public class DirCopy {
    public static void main(String[] args) {
        String src = "D:/copy";
        String filename = "D:/copy:/test";
        SearchAndCopy(src,filename);
    }
    public static void FileCopy(String src,String dest){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(src));
            bos = new BufferedOutputStream(new FileOutputStream(dest));

            byte[] flush = new byte[1024];
            int len = -1;
            while((len = bis.read(flush)) != -1){
                bos.write(flush,0,len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
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
    public static void DirCopy(String src,String dest){
        File f1 = new File(src);
        File[] fs = f1.listFiles();
        File f2 = new File(dest);

        if(! f2.exists()){
            f2.mkdirs();
        }
        for(File f:fs){
            if(f.isFile()){
                FileCopy(f.getPath(),dest+"\\"+f.getName()+"(1)");
            }else if(f.isDirectory()){
                DirCopy(f.getPath(),dest+"\\"+f.getName()+"(1)");
            }
        }
    }

    public static void SearchAndCopy(String src,String fileName){
        File file = new File(src);
        File[] fs = file.listFiles();
        for(File f:fs){
            if(f.get.equals(fileName) && f.isFile()){
                FileCopy(f.getPath(),file.getPath());
            }else if(f.getName().equals(fileName) && f.isDirectory()){
                DirCopy(f.getPath(),file.getPath());
            }
        }
    }
}
