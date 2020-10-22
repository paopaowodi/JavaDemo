import org.w3c.dom.ls.LSOutput;

/**
 * @Author LiYun
 * @Date 2020/9/13 15:57
 * @Version 1.0
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        SolutionContainer2 s  =new SolutionContainer2();
        System.out.println(s.MaxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

}
class SolutionContainer {
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length -1; i++) {
            for (int j = i+1; j < height.length;j++){
                int temp = (j-i) * Math.min(height[j],height[i]);
                if( temp > max){
                    max = temp;
                }
            }
        }
        return max;
    }
}

class SolutionContainer2{
    public int MaxArea(int[] height){
        int max = 0, i = 0, j = height.length-1;
        while(i != j){
            int temp = (j-i)*Math.min(height[i],height[j]);
            if(max < temp){
                max = temp;
            }
            if(height[i] < height[j]){
                i++;
            }else{
                j--;
            }
        }
        return  max;
    }
}