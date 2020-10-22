package cn.second.IOStudy02;

import java.io.*;

/**
 * @Author LiYun
 * @Date 2020/8/4 15:53
 * 文件字节输出流
 * 1、创建源
 * 2、选择流
 * 3、操作（写出内容）
 * 4、释放资源
 */
public class BufferedTest02 {
    public static void main(String[] args) {
        // 1、创建源
        File dest = new File("dest.txt");
        //2、选择流
        OutputStream os =null;
        try{
            os = new BufferedOutputStream(new FileOutputStream(dest,true));
            //3、操作（写出内容）
            String msg = "IO is ok";
            byte[] datas = msg.getBytes();
            os.write(datas,0,datas.length);
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        } finally {
            //4、释放资源
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
