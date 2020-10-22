package cn.test01;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author LiYun
 * @Date 2020/9/13 19:33
 * 全排列
 */
public class pailie {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(4);
        quanpailie(1,list);
    }

    public static String quanpailie(int a,List<Integer> listFirst) {
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < listFirst.size(); i++) {
            list.add(listFirst.get(i));
        }

        System.out.println(a+","+ quanpailie(listFirst.get(0),list));
        System.out.println(quanpailie( listFirst.get(0),list)+ ","+a);

        //递归尾
        if(listFirst.size() == 1){

            System.out.println(sb.append(listFirst.get(0)).toString());
            return sb.append(listFirst.get(0)).toString();
        }

        return "done";
    }
}
