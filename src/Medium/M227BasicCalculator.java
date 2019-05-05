package Medium;

import java.util.ArrayList;
import java.util.List;

public class M227BasicCalculator {
    public int calculate(String s) {
        List<Integer> numbers = new ArrayList<>();
        List<Character> operators = new ArrayList<>();
        int cur = 0;
        while (cur < s.length()) {
            ValueAndLength number = readInt(s, cur);
            if (number == null) break;
            numbers.add(number.value);
            cur += number.length;

            if (cur >= s.length()) break;

            CharAndLength operator = readSymbol(s, cur);
            if(operator == null) break;
            operators.add(operator.value);
            cur += operator.length;
        }


        for (int i = 0; i < operators.size(); i++) {
            char operator = operators.get(i);

            if (operator == '*') {
                int newNumber = numbers.get(i) * numbers.get(i + 1);
                numbers.remove(i + 1);
                numbers.set(i, newNumber);
                operators.remove(i);
                i--;
            }

            if (operator == '/') {
                int newNumber = numbers.get(i) / numbers.get(i + 1);
                numbers.remove(i + 1);
                numbers.set(i, newNumber);
                operators.remove(i);
                i--;
            }
        }


        for (int i = 0; i <operators.size(); i++) {
            char operator = operators.get(i);
            if (operator == '+') {
                int newNumber = numbers.get(i) + numbers.get(i + 1);
                numbers.remove(i + 1);
                numbers.set(i, newNumber);
                operators.remove(i);
                i--;
            }
            if (operator == '-') {
                int newNumber = numbers.get(i) - numbers.get(i + 1);
                numbers.remove(i + 1);
                numbers.set(i, newNumber);
                operators.remove(i);
                i--;
            }
        }

        return numbers.get(0);
    }

    private ValueAndLength readInt(String s, int start) {
        int length = 0;
        int value = 0;
        while(start < s.length() && s.charAt(start) == ' ') {
            start++;
            length ++;
        }
        if (start >= s.length()) return null;

        for (int i = start ; i< s.length(); i++) {
            if (s.charAt(i) > '9' || s.charAt(i) <'0') {
                return new ValueAndLength(value, length);
            }
            length ++;
            value = value * 10 + s.charAt(i) - '0';
        }
        return new ValueAndLength(value, length);
    }
    private CharAndLength readSymbol(String s, int start) {
        int length = 1;
        while(start < s.length() && s.charAt(start) == ' ') {
            start++;
            length ++;
        }
        if (start >= s.length()) return null;
        return new CharAndLength(s.charAt(start), length);
    }



    private class ValueAndLength {
        public int value;
        public int length;
        public ValueAndLength(int value, int length) {
            this.value = value;
            this.length = length;
        }
    }

    private class CharAndLength {
        public char value;
        public int length;
        public CharAndLength(char value, int length) {
            this.value = value;
            this.length = length;
        }
    }
}
