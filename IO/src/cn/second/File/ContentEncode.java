package cn.second.File;

import java.io.UnsupportedEncodingException;

/**
 * @Author LiYun
 * @Date 2020/8/4 14:50
 * 编码：字符串 --> 字节
 */
public class ContentEncode {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String msg = "大学英语a";
        //编码：字节数组
        byte[] datas = msg.getBytes(); //默认工程字符集 UTF-8 英文1 中文3
        System.out.println(datas.length);

        //编码其他字符集
        datas = msg.getBytes("UTF-16LE");//全部为2
        System.out.println(datas.length);

        datas = msg.getBytes("GBK"); //中文2 英文1
        System.out.println(datas.length);

        datas = msg.getBytes();
        //解码
        msg = new String(datas,0,datas.length,"UTF-8");
        System.out.println(msg);

        //乱码
        //1）字节数不够
        //2）字符集不统一
    }
}
