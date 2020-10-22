package cn.second.ly;

import java.io.*;

/**
 * @Author LiYun
 * @Date 2020/9/6 21:45
 * 文件夹的拷贝
 */
public class DirCopy {
    public static void main(String[] args) {
        String src = "D:/copy";
        String dest = "D:/destination";

        Copy(src,dest);

    }
    public static void Copy(String src, String dest){
        File filesrc = new File(src);
        File filedest = new File(dest);
        File[] fs = filesrc.listFiles();
        if(!filedest.exists()){
            filedest.mkdirs();
        }
            for(File f:fs){
                if(f.isFile()){
                    FileCopy(f.getPath(),dest+"\\"+f.getName());
                }else if(f.isDirectory()){
                    Copy(f.getPath(),dest+"\\"+f.getName());
                }
            }

    }

    private static void FileCopy(String src,String dest){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(src));
            bos = new BufferedOutputStream(new FileOutputStream(dest));

            byte[] flush = new byte[1024];
            int len = -1;
            while((len = bis.read(flush))!= -1){
                bos.write(flush,0,len);
            }
            bos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(bis != null)
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(bos != null)
                    bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
