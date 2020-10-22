package NewPoland;

import sun.usagetracker.UsageTrackerClient;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/**
 * @Author LiYun
 * @Date 2020/9/10 20:48
 * 逆波兰计算器：
 * 1.完整功能版
 * 新增功能: 输入错误 括号 首位是符号 小数计算
 */
public class PolishNotation02 {

    public static void main(String[] args) throws Exception {
        Scanner in  = new Scanner(System.in);
        String s = in.nextLine();
        s = upStr(s);

        //判断输入是否合法
        if(!isLogical(s)){
            throw new Exception("输入不合法！");
        }
        PolishNotation02 a = new PolishNotation02(s);
        System.out.println(a.calculate());
    }
    /*--------------属性------------------*/
    private static HashMap<String,Integer> map;

    private String src;


    //优先级分配 --> 构造器
    public PolishNotation02(String src){
        this.src = src;
        if(map == null) {
            map = new HashMap<String,Integer>(7);
            map.put("+", 0);
            map.put("-", 0);
            map.put("*", 1);
            map.put("/", 1);
            map.put("%",1);
            map.put("(", -1);
            map.put(")", 2);
        }
    }

    /*-----------------方法-----------------------*/
    //首位自动补零
    static String upStr(String s){
        StringBuilder sb = new StringBuilder();
        sb.append("0");
        sb.append(s);
        return sb.toString();
    }

    //是否为数字
    static boolean isNum(String str){
        boolean flag = false;
        for(char ch:str.toCharArray()){
            if(ch >= '0' && ch <= '9' || ch == '.'){
                flag = true;
            }else{
                return false;
            }
        }
        return flag;
    }


    //判断括号、符号是否合法
    static boolean isLogical(String str){
        boolean flag = false;   //char是否为运算符号
        Stack<Character> s = new Stack<>();
        for(char ch:str.toCharArray()){
            if(ch == '('){
                flag = false;
                s.push(ch);
            }else if ( ch == ')'){
                if(!s.isEmpty()){
                    s.pop();
                }else{
                    return false;
                }
                flag = false;
            }else if(ch=='+'||ch=='-'||ch=='*'||ch=='/'||ch == '%'){
                if(flag == true){
                    System.out.println("运算符号输入不合法");
                    return false;
                }
                flag = true;
            }else{
                flag = false;
            }
        }
        if(!s.isEmpty()){
            return false;
        }
        return true;
    }

    //字符串分割
    private String[] split(String src) {
        StringBuilder sb = new StringBuilder(src.length());
        for(char ch:src.toCharArray())
        {
            if(ch=='+'||ch=='-'||ch=='*'||ch=='/'||ch=='('||ch==')'||ch == '%')
            {
                sb.append(",");
                sb.append(ch);
                sb.append(",");
            }else{
                sb.append(ch);
            }
        }
        String string = sb.toString().replaceAll(",{2,}", ",");
        return string.split(",");
    }

    //中缀转后缀
    public String RePolish(){
        String[] temp = split(src);
        Stack <String>  s1 = new Stack<>();     //中转栈
        Stack <String>  s2 = new Stack<>();     //最终栈

        for(String s: temp){
            //数字直接进栈
            if(isNum(s)){
                s2.push('('+s+')');
            }else{  //符号
                    if(s1.isEmpty()){
                        s1.push(s);
                    }else {
                        //临时栈不为空，判断栈顶元素的优先级
                        if(s.equals(")")){          //输入是 ")"
                            while(!s1.isEmpty() && ! s1.peek().equals("(")){     // ) 一直弹到 ( 出现
                                s2.push(s1.pop());
                            }
                            s1.pop();
                        }else if(s.equals("(")){
                            s1.push(s);
                        }else {                         //不是 “)”
                            while(!s1.isEmpty() && isPush(s1.peek(),s)){ //比较优先级
                                s2.push(s1.pop());      //栈顶的优先级 >= 输入，则栈顶的元素弹出,之后元素进栈
                            }
                            s1.push(s);
                        }
                    }

            }
        }

        while(! s1.isEmpty()){
            s2.push(s1.pop());
        }
        StringBuilder sb = new StringBuilder();
        for(String str: s2){
            sb.append(str);
        }
        s2.clear();

        return sb.toString();
    }

    //判断优先级,是否进栈
    public boolean isPush(String pop,String str){
        if(map.get(pop) >= map.get(str)){
            return true;
        }else{
            return false;
        }
    }
    //计算

    public double calculate(){
        String src = RePolish();
        Stack<Double> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(char c:src.toCharArray()){
            double x  = 0,y = 0;
            //是数字直接放进栈里面
            if(c == '('){
                continue;
            }else if( c >= '0' && c <= '9' || c == '.'){
                sb.append(c);
            }else if(c == ')'){
                stack.push(Double.valueOf(sb.toString()));
                sb = new StringBuilder();
            }else
                //符号 进行运算
                if(! stack.isEmpty()){
                    if(c == '+'){
                        x = stack.pop();
                        y = stack.pop();
                        stack.push(x+y);
                    }else if( c == '-'){
                        x = stack.pop();
                        y = stack.pop();
                        stack.push(y-x);
                    }else if(c == '*'){
                        x = stack.pop();
                        y = stack.pop();
                        stack.push(x*y);
                    }else if(c == '/'){
                        x = stack.pop();
                        y = stack.pop();
                        stack.push(y/x);
                    }else if(c == '%'){
                        x = stack.pop();
                        y = stack.pop();
                        stack.push(y%x);
                    }
                }
        }

        return stack.pop();
    }
}
