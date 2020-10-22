package cn.second.IOstudy01;

import java.io.*;

/**
 * @Author LiYun
 * @Date 2020/8/4 15:53
 * 文件字节输入输出流
 * 1、创建源
 * 2、选择流
 * 3、操作（写出内容）
 * 4、释放资源
 */
public class Copy {
    public static void main(String[] args) {

    }
    public static void copy(String srcPath,String destPath) {
        // 1、创建源
        File dest = new File(destPath);
        File src = new File(srcPath);
        //2、选择流
        OutputStream os =null;
        InputStream is =null;
        try{
            is = new FileInputStream(src);
            os = new FileOutputStream(dest,true);
            //3、操作（写出内容）
            byte[] flush = new byte[1024];
            int len = -1; //接收长度
            while((len = is.read(flush)) != -1){
                os.write(flush,0,len);
            }
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        } finally {
            //4、释放资源 分别关闭 先打开的后关闭
            try {
                if(null != is){
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            if(null != os){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
