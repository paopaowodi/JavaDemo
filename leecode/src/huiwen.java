/**
 * @Author LiYun
 * @Date 2020/9/6 10:55
 * @Version 1.0
 */
public class huiwen {
    public static void main(String[] args) {
        String s = "meabccbad";
        Solution2 so = new Solution2();
        String anw = so.longestPalindrome(s);
        System.out.println(anw);
    }
}

class Solution2 {
    public String longestPalindrome(String s) {

        int start = 0, end = 0;
        if(s.length() < 2 )
            return "";
        for(int i = 0; i < s.length()-1; i++){
            int len1 = Helper(s,i,i);
            int len2 = Helper(s,i,i+1);
            int len = Math.max(len1,len2);
            if(len > end-start){
                start = i-(len-1)/2;
                end = i+len/2;
            }
        }
        return s.substring(start,end + 1);
    }

    int Helper(String s, int left, int right){
        while(left > -1 && right <s.length() && s.charAt(left) == s.charAt(right) ){
            left--;
            right++;
        }
        return right-left-1; //跳出循环时已经不是回文数了，所以-1而不是+1
    }
}
