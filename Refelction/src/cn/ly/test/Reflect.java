package cn.ly.test;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author LiYun
 * @Date 2020/9/17 22:27
 * @Version 1.0
 */
public class Reflect {
    public static void main(String[] args) throws Exception {
        Create();
    }


    public static void Create() throws Exception{
        URL resource = Reflect.class.getResource("");
        //  URL resource1 = ClassLoader.getSystemClassLoader().getResource("");
        //  System.out.println(resource1.toString());
        String string = resource.toString();
        String substring = string.substring(6);
        System.out.println(substring);
        File file = new File(substring);
        File[] files = file.listFiles();
        Map<String, Object> map = new HashMap<>();

            for(File file1:files){
            //  System.out.println(file1.getName());
                if (file1.getName().contains(".class")) {
                    System.out.println(file1.getName());
                    String split = file1.getName().substring(0, file1.getName().length() - 6);
                    System.out.println(split);
                    String[] substring1 = string.split("/");

                    Class aClass = Class.forName(substring1[substring1.length - 1] + "." + split);
                    Object o = aClass.newInstance();
                    map.put(file1.getName(), o);
                }
            }
        }
}