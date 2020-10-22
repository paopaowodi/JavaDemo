package cn.first.readerwriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author LiYun
 * @Date 2020/7/16 20:51
 * 文本文件的复制
 */
public class Test03 {
    public static void main(String[] args) {
        String src = "d:/abc.txt";
        String dest = "d:/xyz.txt";
        copyFile1(src, dest);
    }

    public static void copyFile1(String srcFilename, String destFilename) {
        try (
                FileReader fr = new FileReader(srcFilename);
                FileWriter fw = new FileWriter(destFilename);
        ) {


            int cc = fr.read();
            while (cc != -1) {
                fw.write(cc);
                cc = fr.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void copyFile2(String srcFilename, String destFilename) {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            fr = new FileReader(srcFilename);
            fw = new FileWriter(destFilename);

            char[] contents = new char[1024];
            int len = fr.read(contents);
            while (len != -1){
                fw.write(contents,0,len);
                len = fr.read(contents);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fr != null){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fw != null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}