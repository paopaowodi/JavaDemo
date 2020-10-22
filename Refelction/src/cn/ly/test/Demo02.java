package cn.ly.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author LiYun
 * @Date 2020/8/10 16:03
 * 应用反射的API，获取类的信息(类的名字、属性、方法、构造器等)
 */
public class Demo02 {
    public static void main(String[] args) {
        String path = "cn.ly.test.bean.User";
        try {
            Class clazz = Class.forName(path);

            //类的名字
            System.out.println(clazz.getName()); //获得包名+类名
            System.out.println(clazz.getSimpleName());//类名：User

            //获取属性信息
            Field[] fields = clazz.getFields();//只能获得public的field
            Field[] declaredFields = clazz.getDeclaredFields();//获得所有的field
            Field f = clazz.getDeclaredField("uname");
            for(Field temp:declaredFields){
                System.out.println("属性："+temp);
            }

            //获得方法信息
            Method[] methods = clazz.getDeclaredMethods();
            Method m01 = clazz.getDeclaredMethod("getUname", null);
            Method m02 = clazz.getDeclaredMethod("setUname", String.class);
            for(Method m:methods){
                System.out.println("方法："+m);
            }
            //获得构造器信息
            Constructor[] constructors= clazz.getDeclaredConstructors();
            Constructor c = clazz.getDeclaredConstructor(null);
            System.out.println("获得构造器："+c);
            for(Constructor temp:constructors){
                System.out.println("构造器："+temp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
