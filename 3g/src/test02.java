/**
 * @Author LiYun
 * @Date 2020/7/22 19:01
 * @Version 1.0
 */


public class test02{

    int[] b = {1,3,5,6};

    public int set(int[] array, int dest){
        int left = 0,len = array.length,right = len-1;
        int ans;
        int mid = 0;
        while(left <= right){
            mid = left + (right-left) /2;
            if(dest < array[mid]){
                right = mid-1;
            }else if(dest == array[mid]){
                return mid;
            }else if(dest > array[mid]){
                left = mid+1;
            }
        }
        ans = left;
        return ans;
    }

    public static void main(String[] args) {
        test02 a = new test02();
        int ans = a.set(a.b,2);
        System.out.println(ans);
    }
}