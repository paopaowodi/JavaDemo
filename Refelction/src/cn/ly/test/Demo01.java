package cn.ly.test;

/**
 * @Author LiYun
 * @Date 2020/8/10 15:43
 * 测试各种类型对应的(class,interface,annotation,primitive type,void) java.lang.Class对象的获取方式
 */
@SuppressWarnings("all")
public class Demo01 {


    public static void main(String[] args) {
        String path = "cn.ly.test.bean.User";

        try {
            Class clazz = Class.forName(path);
            //对象是表示或封装一些数据。一个类被加载后，JVM会创建一个对应类的Class对象，
            //整个类的结构信息会被放到对应的Class对象中
            System.out.println(clazz.hashCode());

            Class clazz2 = Class.forName(path);//体现了一个类只对应一个Class对象
            System.out.println(clazz.hashCode());

            Class strClazz = String.class;
            Class strClazz2 = path.getClass();
            System.out.println(strClazz == strClazz2);

            Class intClazz = int.class;

            int[] a = new int[10];
            int[] a2 = new int[30]; //和维度有关 和长度无关

            System.out.println(a.getClass().hashCode());
            System.out.println(a2.getClass().hashCode());

            double[] a3 = new double[40];
            System.out.println(a3.getClass().hashCode());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
