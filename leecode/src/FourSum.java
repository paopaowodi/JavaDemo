import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @Author LiYun
 * @Date 2020/10/13 13:56
 * 18.四数之和
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
 * 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FourSum {
    public static void main(String[] args) {
        int[] nums = {-3,-2,-1,0,0,1,2,3};
        int target = 0;
        List<List<Integer>> lists = fourSum(nums, target);
        System.out.println(lists);
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> anw = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return anw;
        }
        Arrays.sort(nums);
        int left = 0, right = 0;
        int index = 0;
        for (int i = 0; i < nums.length-3; i++) {
            if(i>0 && nums[i-1] == nums[i]){
                continue;
            }
            for (int j = i+1; j < nums.length-2; j++) {
                if(j > i+1 && nums[j-1] == nums[j]){
                    continue;
                }
                left = j+1;
                right = nums.length-1;
                while(left < right){
                    int sum = nums[i]+nums[j]+nums[left]+nums[right];
                    if( sum == target){
                        List<Integer> a = new ArrayList<>();
                        a.add(nums[i]);
                        a.add(nums[j]);
                        a.add(nums[left]);
                        a.add(nums[right]);
                        anw.add(a);
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    }
                    if(sum > target){
                        right--;
                    }
                    if(sum < target){
                        left++;

                    }
                }
            }
        }
        return anw;
    }
}
