package 容器;

import java.util.List;
import java.util.ArrayList;
/**
 * 测试泛型
 * @李云
 *
 * */
public class TestGenerit {
    public static void main(String[] args) {
        MyCollection<String> mc = new MyCollection<String>();
        mc.set("李云",0);

        String b = mc.get(0);


        List list = new ArrayList();
    }

}

class MyCollection<E>{
    Object[] objs = new Object[5];

    public void set(E e,int index){
        objs[index] = e;
    }

    public E get(int index){
        return (E)objs[index];
    }
}
