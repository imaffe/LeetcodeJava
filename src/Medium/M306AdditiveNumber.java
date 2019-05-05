package Medium;

public class M306AdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        int len = num.length();
        if (len <= 2) return false;

        for (int i = 1; i < len/2; i ++) {
            for (int j = 1; j <= Math.min(i , (len - i) / 2); j++) {
                int num1 = Integer.valueOf(num.substring(0, i));
                int num2 = Integer.valueOf(num.substring(i, i+j));
                boolean res = checkAdditive(num1, num2, num.substring(i + j, num.length()));
                if (res) return true;
            }
        }
        return false;
    }

    private boolean checkAdditive(int num1, int num2, String nums) {
        if (nums.length() == 0) return true;
        int add = num1 + num2;
        int lenAdd = String.valueOf(add).length();
        int target = Integer.valueOf(nums.substring(0, lenAdd));
        if (target != add) return false;
        else return checkAdditive(num2, add, nums.substring(lenAdd, nums.length()));
    }
}

// TODO : 1. check whether start with 0 2. deal with long number
