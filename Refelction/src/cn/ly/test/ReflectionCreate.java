package cn.ly.test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author LiYun
 * @Date 2020/9/17 21:55
 * 反射创建当前同级文件下的类文件,并将创建的对象存入map中其中 key是类名，value是反射创建的对象
 */
public class ReflectionCreate {
    private Map<String,Class> map;

    public ReflectionCreate(Map<String, Class> map) {
        map = new HashMap<>();
    }

    public static void main(String[] args) throws Exception {
        String s = "cn.ly.test";

            getFile(s);

    }
    public static void getFile(String src) throws Exception {
        File file = new File(src);
        File[] fs = file.listFiles();

        for(File f: fs){
            createObj(f.getPath()+f.getName());
        }
    }

    public static void createObj(String path) throws Exception{
        Class<?> clazz = Class.forName(path);
        Object obj = clazz.newInstance();
        System.out.println("创建了 "+clazz.getName()+" 运行类的对象");
    }
}
