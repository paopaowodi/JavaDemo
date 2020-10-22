package cn.test01;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author LiYun
 * @Date 2020/9/13 19:16
 * 反射
 * 反射创建当前同级文件下的类文件并将创建的对象存入 map中其中 key是类名，value是反射创建的对象
 */
public class Reflection {

    public static void main(String[] args) throws ClassNotFoundException {
        String path = "src\\cn\\test01\\A";
        Class<?> clazz = Class.forName(path);
        Map<String,Class> map = new HashMap<>();
        map.put(clazz.getName(),clazz);
    }
}

class Reflect{

}
