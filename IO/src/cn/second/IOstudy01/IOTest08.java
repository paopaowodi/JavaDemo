package cn.second.IOstudy01;

import java.io.*;

/**
 * @Author LiYun
 * @Date 2020/8/4 15:53
 * 字节数组输出流 ByteArrayOutputStream
 * 1、创建源 ：内部维护
 * 2、选择流：不关联源
 * 3、操作（写出内容）
 * 4、释放资源：可以不用
 *
 * 获取数据：toByteArray
 */
public class IOTest08 {
    public static void main(String[] args) {
        // 1、创建源
        byte[] dest = null;  //不用创建
        //2、选择流 (新增方法) 
        ByteArrayOutputStream baos =null;
        try{
            baos = new ByteArrayOutputStream();
            //3、操作（写出内容）
            String msg = "IO is ok";
            byte[] datas = msg.getBytes();
            baos.write(datas,0,datas.length);
            baos.flush();
            //获取数据
            dest = baos.toByteArray();
            System.out.println(dest.length+"--->"+new String(dest,0,baos.size()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        } finally {
            //4、释放资源
            if(null != baos){
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
