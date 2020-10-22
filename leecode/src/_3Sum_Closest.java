import java.lang.reflect.Array;
import java.util.Arrays;

import static java.lang.Math.abs;

/**
 * @Author LiYun
 * @Date 2020/10/10 10:19
 * @Version 1.0
 */
public class _3Sum_Closest {
    public static void main(String[] args) {
        int[] nums = {1,1,1,0};
        int anw = threeSumClosest(nums,-100);
        System.out.println(anw);
    }
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int temp = 9999999;
        int sum = 0;
        int anw = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i+1, r = nums.length-1;

            while(l < r){
                sum = nums[i]+nums[l]+nums[r];
                if(sum == target){
                    return sum;
                }
                if(Math.abs(sum-target) < temp){
                    temp = Math.abs(sum-target);
                    anw = sum;
                }
                if(sum > target){
                    r--;
                }else {
                    l++;
                }
            }
        }
        return anw;
    }
}
class SolutionThreeSum01 {  //暴力解法 时间复杂度0(n^3)
    public int threeSumClosest(int[] nums, int target) {
        int sum = 0, temp = 999999999,anw = 0;

        for (int i = 0; i < nums.length-2; i++) {
            for(int j = i+1; j < nums.length-1; j++){
                for(int k = j+1; k < nums.length; k++){
                    sum = nums[i]+nums[j]+nums[k];
                    if(Math.abs(sum-target) < temp){
                        temp = Math.abs(sum-target);
                        anw = sum;
                    }
                }
            }
        }
        return anw;
    }
}

class SolutionThreeSum02 {  //双指针解法
    public static int[] nums = {1,1,1,0};
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int temp = 9999999;
        int sum = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i+1, r = nums.length-1;

            while(l < r){
                sum = nums[i]+nums[l]+nums[r];
                if(sum == target){
                    return sum;
                }
                if(Math.abs(sum-target) < temp){
                    temp = Math.abs(sum-target);
                }
                if(sum > target){
                    r--;
                }else {
                    l++;
                }
            }
        }
        return temp;
    }
}