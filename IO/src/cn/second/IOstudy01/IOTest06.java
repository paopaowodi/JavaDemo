package cn.second.IOstudy01;

import java.io.*;

/**
 * @Author LiYun
 * @Date 2020/8/4 15:53
 * 文件字符输出流
 * 1、创建源
 * 2、选择流
 * 3、操作（写出内容）
 * 4、释放资源
 */
public class IOTest06 {
    public static void main(String[] args) {
        // 1、创建源
        File dest = new File("dest.txt");
        //2、选择流
        Writer writer =null;
        try{
            writer = new FileWriter(dest);
            //3、操作（写出内容）
//             // 写法一
//            String msg = "IO is ok 带我一起";
//            char[] datas = msg.toCharArray();//字符串-->字符数组
//            writer.write(datas,0,datas.length);

//            //写法二
//            String msg = "酒精棉花 waterproof";
//            writer.write(msg);

            //写法三 append
            writer.append("酒精棉花 waterproof").append("套娃");


            writer.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        } finally {
            //4、释放资源
            if(null != writer){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
