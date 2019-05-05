package Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class M017LetterNumber {
    public String[] mapping = {"0","1","abc","def","ghi", "jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        // This needs to know the difference of outer and inner loop difference

        int n = digits.length();

        List<String> result = new ArrayList<String>();
        if (n == 0) return result;
        result.add("");
        for (int i = 0; i < n; i++){
            result = combine(result, digits.charAt(i) - '0');
        }
        return result;
    }

    public List<String> combine(List<String> result, int number) {
        List<String> newResult = new ArrayList<String>();
        int len = result.size();
        int setLength = mapping[number].length();
        for (int i = 0 ; i < setLength; i++){
            for (int j = 0; j < len; j++) {
                newResult.add(result.get(j) + mapping[number].charAt(i));
            }
        }
        return newResult;
    }
}
