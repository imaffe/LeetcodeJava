package Medium;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;
import java.util.Stack;

public class M394DecodeString {
    public String decodeString(String s) {
        Stack<String> expression = new Stack<>();

        readString(s, expression, 0);
        Iterator<String> iter = expression.iterator();
        String res = "";
        while(iter.hasNext()) {
            res += iter.next();
        }
        return res;
    }

    // need to write some helper functions to parse this string
    // very Java Speaking !
    private void readString(String s, Stack<String> expression, int cur) {
        if (cur >= s.length()) return;

        if (s.charAt(cur) == '[') {
            expression.push("[");
            cur++;
        } else if (isAlpha(s.charAt(cur))) {
            String str = "";
            while(cur < s.length() && isAlpha(s.charAt(cur))) {
                str += s.charAt(cur);
                cur ++;
            }
            expression.push(str);
        } else if (isNumber(s.charAt(cur))) {
            String num = "";
            while(cur < s.length() && isNumber(s.charAt(cur))) {
                num += s.charAt(cur);
                cur ++;
            }
            expression.push(num);
        } else {
            // read ]
            String str = "";
            while(isAlpha(expression.peek().charAt(0))) {
                String next = expression.pop();
                str = next + str;
            }
            expression.pop();
            int num = Integer.valueOf(expression.pop());
            String newstr = "";
            for (int i = 0 ; i < num; i++) {
                newstr += str;
            }
            expression.push(newstr);
            cur++;
        }

        readString(s, expression, cur);
    }

    private boolean isAlpha(char c) {
        return ((c >= 'a' && c <= 'z' )||(c >='A' && c <='Z'));
    }

    private boolean isNumber(char c) {
        return ((c >= '0' && c <= '9' ));
    }
}
