import org.w3c.dom.ls.LSOutput;

/**
 * @Author LiYun
 * @Date 2020/9/13 14:42
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 *
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
 *
 * 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
 * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
 *
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0 。

 */
public class StringToInteger {
    public static void main(String[] args) {
        SolutionString s = new SolutionString();
        System.out.println(s.myAtoi(""));
    }

}
class SolutionString {
    public int myAtoi(String str) {
        char[] chars = str.toCharArray();
        int  index = 0;
        int  sign = 1;
        int num = 0;
        //除去空格
        while(index < str.length() &&chars[index] == ' '){
            index++;
        }
        if(index == str.length()){
            return 0;
        }
        //除去字母 除去 + - 符号
        char c = chars[index];
        if(c == '+'){
            index++;
        }else if( c == '-'){
            sign =  -1;
            index++;
        }
        while(index < str.length()){

            c = chars[index];

           if(c < '0' || c > '9'){
               break;
           }
           if(num >Integer.MAX_VALUE /10 || (num == Integer.MAX_VALUE/10 && (c-'0')>(Integer.MAX_VALUE % 10))){
               return Integer.MAX_VALUE;
           }
           if(num*sign < Integer.MIN_VALUE/10 || num* sign == Integer.MIN_VALUE/10 && (c-'0')> -(Integer.MIN_VALUE % 10)){
               return Integer.MIN_VALUE;
           }

           num = num * 10 + c - '0';
           index++;

        }
        return num*sign;
    }
}