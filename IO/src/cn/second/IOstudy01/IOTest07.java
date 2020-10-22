package cn.second.IOstudy01;

import java.io.*;

/**
 * @Author LiYun
 * @Date 2020/8/4 15:53
 * 字节数组输入流
 *
 * 1、创建源 ： 字节数组 不要太大
 * 2、选择流
 * 3、操作（打印）
 * 4、释放资源 ： 可以不用处理
 */
public class IOTest07 {
    public static void main(String[] args) {
        // 1、创建源
        byte[] src = "show me your code".getBytes();
        //2、选择流
        InputStream is = null;
        try{
            is = new ByteArrayInputStream(src);
            //3、操作（写出内容）
            byte[] flush = new byte[5];
            int len = -1;
            while((len = is.read(flush)) != -1 ){
                String str = new String(flush,0,len);
                System.out.println(str);
            }
        }catch (IOException e){
            e.printStackTrace();
        } finally {
            //4、释放资源
            if(null != is){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
