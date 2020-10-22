package cn.ly.test;

import cn.ly.test.bean.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author LiYun
 * @Date 2020/8/11 16:19
 * 通过反射API动态的操作：构造器、方法、属性
 */
public class Demo03 {
    public static void main(String[] args) {
        String path = "cn.ly.test.bean.User";
        try {
            Class clazz = Class.forName(path);

            //通过反射API调用构造方法：构造对象
            User u = (User)clazz.newInstance(); //其实是调用了User的无参构造方法
            System.out.println(u);

            Constructor<User> c = clazz.getDeclaredConstructor(int.class,int.class,String.class);
            User u2 = c.newInstance(1001,19,"兔子");
            System.out.println(u2.getUname());

            //通过反射API调用普通方法
            User u3 = (User) clazz.newInstance();
            //u3.setUname("秃子");
            Method method = clazz.getDeclaredMethod("setUname", String.class);
            method.invoke(u3,"秃子");
            System.out.println(u3.getUname());

            //通过反射API操作属性
            User u4 = (User)clazz.newInstance();
            Field f= clazz.getDeclaredField("uname");
            f.setAccessible(true); //这个属性不需要做安全检查了，可以直接访问
            f.set(u4,"okok");
            System.out.println(u4.getUname());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
