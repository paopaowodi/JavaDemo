package cn.first.object;

import java.io.Serializable;

/**
 * @Author LiYun
 * @Date 2020/7/17 9:12
 * Person类的对象序列化是Person类实现serializable接口
 *      该接口没有任何方法
 */
public class Person implements Serializable {
    String name;
    int age;
    //手动添加一个 序列化版本号字段
    private static final long serialVersionUID = -6812344470754667710L;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
