package cn.second.ly;

import java.io.*;

/**
 * @Author LiYun
 * @Date 2020/8/4 16:08
 * @Version 1.0
 */
public class IOTest02 {
    public static void main(String[] args) {
        File dest = new File("dest.txt");
        OutputStream os = null;
        try {
            os = new FileOutputStream(dest);
            String str = "ok i am gay";
            byte[] datas = str.getBytes();
            os.write(datas,0,datas.length);
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
