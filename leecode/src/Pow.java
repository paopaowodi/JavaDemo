/**
 * @Author LiYun
 * @Date 2020/9/6 8:56
 * @Version 1.0
 */

public class Pow {
    public static void main(String[] args) {
        Solution x = new Solution();
        double anw = x.myPow(2.0,10);
        System.out.println(anw);

    }

}
class Solution {
    public double myPow(double x, int n) {
        if(x == 1|| n == 0){
            return 1;
        }
        if(n > 0) return myPowHelper(x,n);

        else return 1/myPowHelper(x,Math.abs(n));

    }
    double myPowHelper(double x , int n){
        double half;
        if(n == 1){
            return x;
        }
        if(n % 2 != 0){
            half = myPowHelper(x,n/2);
            return half*half*x;
        }else{
            half = myPowHelper(x,n/2);
            return half*half;
        }
    }
}