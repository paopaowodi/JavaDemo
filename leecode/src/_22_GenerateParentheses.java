import java.util.*;

/**
 * @Author LiYun
 * @Date 2020/10/15 12:31
 * 22.
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 */
public class _22_GenerateParentheses {
    public static void main(String[] args) {

    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n == 0){
            return res;
        }
        dfs("",n,n,res);
        return res;
    }

    private void dfs(String cutStr,int left,int right,List<String> res){
        if(left == 0 && right == 0){
            res.add(cutStr);
            return;
        }
        if(left > right){
            return;
        }
        if(left > 0){
            dfs(cutStr+"(",left-1,right,res);
        }
        if(right > 0){
            dfs(cutStr+")",left,right-1,res);
        }
    }

}
