package cn.ly.DynamicProgramming;

import java.util.Scanner;

/**
 * @Author LiYun
 * @Date 2020/9/6 14:34
 * 币值最大化问题
 * 题目：给定一排n个硬币，其面值均为正整数c1，c2，...，cn，这些整数并不一定两两不同。
 * 请问如何选择硬币，使得在其原始位置互不相邻的条件下，所选硬币的总金额最大。
 */
public class Demo01 {
    static int[] arr = new int[6];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 6; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(CoinRow(arr.length-1));
    }
    static int CoinRow(int n){
        if(n == 0){
            return 0;
        }
        if(n  == 1 ){
            return arr[1];
        }
        return  Math.max(CoinRow(n-2)+arr[n],CoinRow(n-1));
    }
}
