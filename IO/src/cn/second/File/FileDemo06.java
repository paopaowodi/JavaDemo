package cn.second.File;

import java.io.File;
import java.io.IOException;

/**
 * @Author LiYun
 * @Date 2020/8/4 10:39
 * 其他信息02：
 *  createNewFile(): 不存在才创建，存在创建成功
 *  delete()
 */
public class FileDemo06 {
    public static void main(String[] args) throws IOException {
        File src = new File("C:\\Users\\Dell\\Pictures\\Saved Pictures\\io.txt");
        boolean flag = src.createNewFile();
        System.out.println(flag);

        src = new File("C:\\Users\\Dell\\Pictures\\Saved Pictures\\study");
        flag = src.createNewFile();
        System.out.println(flag);

        src.delete();
        System.out.println(flag);
    }
}
