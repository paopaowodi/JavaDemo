package cn.ly.readerwriter;

import java.io.InputStreamReader;

/**
 * @Author LiYun
 * @Date 2020/7/16 21:14
 *
 * 文本文件与当前环境编码不兼容 InPutStreamReader/OutPutStreamWriter
 */
public class Test04 {
    public static void main(String[] args) {
        m1(); //使用InPutStreamReader读取文件内容
    }

    private static void m1() {


        InputStreamReader isr = new InputStreamReader(in,"GBK");


    }



}
