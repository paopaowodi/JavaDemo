package cn.ly.DynamicProgramming;

/**
 * @Author LiYun
 * @Date 2020/9/6 14:51
 * 找零问题
 * 题目：需找零金额为 n，最少要用多少面值为d1<d2<…<dm的硬币？
 * （m种面值的各种硬币，d1=1，数量无限）
 *
 * 返回：最少硬币的个数
 */
public class Demo02 {
    static int[]D = {1,3,4};
    public static void main(String[] args) {
        System.out.println(ChangeMaking(6));
    }
    static int ChangeMaking(int n){
        if(n == 0) return 0;
        int temp = 99999999;
        for (int i = 1; i < n; i++) {
            temp = 99999999;
            int j = 1;
            while(j <= D.length-1 && i >= D[j]){
                temp = Math.min(ChangeMaking(i-D[j]),temp);
                j++;
            }

        }
        return temp + 1;
    }
}
