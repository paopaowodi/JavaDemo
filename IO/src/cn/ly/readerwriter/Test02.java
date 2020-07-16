package cn.ly.readerwriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author LiYun
 * @Date 2020/7/16 20:43
 * FileWriter 保存数据时，只能把数据保存到UTF8（当前环境）格式的文件中
 */
public class Test02 {
    public static void main(String[] args) throws IOException {
        FileWriter fw = null;
        try {
            //如果文件不存在，会创建一个新的文件，如果文件存在会覆盖原来的内容
            fw = new FileWriter("d:/xyz.txt");
            //追加，加个true


            fw.write('A');
            fw.write('汉');

            fw.write("一次一个字符串");
            //换行
            fw.write("\r\n");
            //一次写一个字符数组
            char[] contents = "听说今天能够收到花，但是没有".toCharArray();
            fw.write(contents);
            //把字符数组的部分数组写进去
            fw.write(contents,0,5);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fw!= null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
