import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author LiYun
 * @Date 2020/9/7 21:36
 * Z字形
 */
public class Z {

}
class Solution3 {
    public String convert(String s, int numRows) {
        if(s.length() <= numRows || numRows == 1){
            return s;
        }
       List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        int curRow = 0;
        boolean goingDown = false;

        for(char c:s.toCharArray()){
            rows.get(curRow).append(c);
            if(curRow == 0 || curRow == numRows-1){
                goingDown = !goingDown;
            }
            curRow += goingDown?1:-1;
        }
        StringBuilder str = new StringBuilder();
        for(StringBuilder row : rows){
            str.append(row);
        }
        return str.toString();
    }
}
