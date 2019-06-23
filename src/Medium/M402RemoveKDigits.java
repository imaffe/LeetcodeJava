package Medium;

public class M402RemoveKDigits {
    public String removeKdigits(String num, int k) {
        String result;
        result = wrappedRemove(num, k);
        return removeHeadZeros(result);
    }

    public String wrappedRemove(String num, int k){
        if (k == 0) return num;
        if (num.length() == k) return "";
        Character firstChar = num.charAt(0);
        Character secondChar = num.charAt(1);
        if (firstChar > secondChar) {
            return wrappedRemove(num.substring(1), k - 1);
        } else {
            // find one that is smaller than current one
            int index = findFirstSmaller(num, firstChar);
            if(index == -1) {
                return Character.toString(firstChar).concat(wrappedRemove(num.substring(1), k));
            } else if (index > k) {
                return Character.toString(firstChar).concat(wrappedRemove(num.substring(1), k));
            } else {
                return wrappedRemove(num.substring(index), k - index);
            }
        }
    }

    public int findFirstSmaller(String targetStr, Character firstChar) {
        for (int i = 0 ; i < targetStr.length(); i++){
            if (targetStr.charAt(i) < firstChar) return i;
        }

        return -1;
    }

    public String removeHeadZeros(String str) {
        if (str == "") return "0";
        int cur = 0;
        while(cur < str.length() &&str.charAt(cur) == '0') cur ++;
        if (str.substring(cur) == "") return "0";
        else return str.substring(cur);
    }

}
