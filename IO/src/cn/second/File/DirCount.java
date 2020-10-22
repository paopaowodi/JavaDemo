package cn.second.File;

import java.io.File;

/**
 * @Author LiYun
 * @Date 2020/8/4 11:06
 * 统计文件夹大小
 */
public class DirCount {

    private long len;  //大小
    private  String path; //路径
    private File src; //源
    //文件个数
    private int fileSzie;
    private int dirSzie;

    public DirCount(String path) {
        this.path= path;
        this.src = new File(path);
        count(this.src);
    }

    public static void main(String[] args) {
        DirCount dir = new DirCount("D:\\learngit\\IO\\src\\cn");
        System.out.println(dir.getLen());

    }
    private void count(File src){
        //获取大小
        if(null != src && src.exists()){
            if(src.isFile()){
                len += src.length();
            }else{
                for(File s: src.listFiles()){
                    count(s);
                }
            }
        }
    }

    public long getLen() {
        return len;
    }

    public int getFileSzie() {
        return fileSzie;
    }

    public int getDirSzie() {
        return dirSzie;
    }
}
