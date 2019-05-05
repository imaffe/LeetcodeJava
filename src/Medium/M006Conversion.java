package Medium;

public class M006Conversion {
    public String convert(String s, int numRows) {
        String [] rows = new String[numRows];
        String res = "";
        for (int i = 0; i < numRows; i++) {
            rows[i] = "";
        }
        int n =s.length();
        int cursor = 0;
        boolean increase = false;
        if (numRows == 1) return s;
        for (int i = 0; i < n ; i++){
            rows[cursor] += s.charAt(i);
            if(cursor == numRows - 1 || cursor == 0) increase = !increase;
            if (increase) {
                cursor ++;
            } else {
                cursor --;
            }
        }
        for (int i = 0; i < numRows; i++) {
            res += rows[i];
        }
        return res;
    }
}
