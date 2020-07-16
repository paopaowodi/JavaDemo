package cn.ly.fileiostream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author LiYun
 * @Date 2020/7/16 15:03
 * 文件的复制
 */
public class Test05 {
    public static void main(String[] args) throws IOException {
         String src = "d:/abc.txt";
        String deString = "d:/def.txt";


        copyFile(src,deString);
    }
   //一次复制一个字节数组，异常处理，自动关闭流
    public static void copyFile(String srcFilename, String destFilename){
        try(
                FileInputStream fis = new FileInputStream(srcFilename);
                FileOutputStream fos = new FileOutputStream(destFilename);
                ){
            byte[] bytes = new byte[1024];  //字节数组一般是1024的偶数倍
            int len = fis.read(bytes);
            while(len != -1){
                fos.write(bytes,0,len);
                len = fis.read(bytes);
            }


        }catch(Exception e){
            e.printStackTrace();
        }
    }



    //一次复制一个字节， 从原文件读一个字节，写到复制文件
    public static void copyFile1(String srcFilename, String destFilename)  {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(srcFilename);
            fos = new FileOutputStream(destFilename);

            int cc = fis.read();
            while(cc != -1){
                fos.write(cc);  //把读到的字节cc保存道输出流中
                cc = fis.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
