import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author LiYun
 * @Date 2020/10/10 11:02
 * @Version 1.0
 */
public class LetterCombinationsPhoneNumber {
    public static void main(String[] args) {
        letterCombinations("234");
    }

    public static List<String>  letterCombinations(String digits) {
        if(digits == null ||digits.length() == 0){
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        res.add("");
        Map<Integer,String> dic = new HashMap<>();
        dic.put(2,"abc");
        dic.put(3,"def");
        dic.put(4,"ghi");
        dic.put(5,"jkl");
        dic.put(6,"mno");
        dic.put(7,"pqrs");
        dic.put(8,"tuv");
        dic.put(9,"wxyz");

        for(int i = 0; i < digits.length();i++){
            String letters = dic.get(digits.charAt(i)-'0');
            int size = res.size(); //???
            for(int j = 0; j < size; j++){
                String temp = res.remove(0);
                for(int k = 0; k < letters.length();k++){
                    res.add(temp+letters.charAt(k));
                }
            }
        }
        return res;
    }
}
