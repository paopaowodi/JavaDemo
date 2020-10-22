package PolandNotation;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Author LiYun
 * @Date 2020/9/9 23:32
 * 逆波兰计算器
 * 功能:
 * 实现0-9的加减法 = =
 */
public class PolandNotation {
    public static void main(String[] args) {
        String express = "9+(3-1)*3+4/2#";
        Stack<Object> s = RePolish(express);
//        PrintPolish(s);
        System.out.println(calculate(s));
    }

    public static Stack RePolish(String expression){
        Stack<Object> s1 = new Stack<>();
        Stack<Object> s2 = new Stack<>();

        s1.push('#');
        for(int i = 0; i < expression.length();i++){
            char c = expression.charAt(i);

            if(c == '#'){
                while((char)s1.peek() != '#'){
                    s2.push(s1.pop());
                }
                break;
            }else if(c >= '0' && c <= '9'){
                s2.push(c);
            }else if(c == '('){
                s1.push(c);
            }else if(c == '+' || c == '-'){
                while((char)s1.peek() != '#' && (char)s1.peek() != '('){
                        s2.push(s1.pop());
                }
                s1.push(c);
            }else if(c == '*' || c == '/'){
                while((char)s1.peek() == '*' || (char)s1.peek()== '/'){
                    s2.push(s1.pop());
                }
                s1.push(c);
            }else if(c == ')'){
                while((char)s1.peek() != '('){
                    s2.push(s1.pop());
                }
                s1.pop();
            }
        }
        return s2;
    }

    public static int calculate(Stack<Object> s){
        Stack<Integer> calculate = new Stack<>();
        Stack<Object> copy = new Stack<>();
        while(!s.isEmpty()){
            copy.push(s.pop());
        }

        while(! copy.isEmpty()){
            char c = (Character) copy.pop();
            if(c >= '0' && c <= '9'){
                calculate.push(c-'0');
            }else if(c == '+'){
                int temp = calculate.pop();
                calculate.push(temp+calculate.pop());
            }else if(c == '-'){
                int temp = calculate.pop();
                calculate.push(calculate.pop()-temp);
            }else if(c == '*'){
                int temp = calculate.pop();
                calculate.push(calculate.pop()*temp);
            }else if(c == '/'){
                int temp = calculate.pop();
                calculate.push(calculate.pop()/temp);
            }

        }
        return calculate.pop();
    }

    public static void PrintPolish(Stack s){
        while (!s.isEmpty()){
            System.out.print(s.pop()+" ");
        }
        System.out.println();
    }

}

