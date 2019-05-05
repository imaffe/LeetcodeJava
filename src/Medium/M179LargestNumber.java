package Medium;

public class M179LargestNumber {
    public String largestNumber(int[] nums) {
        // first sort nums according a different criterion
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums.length - i - 1; j++) {
                if (smallerThan(nums[j], nums[j+1])) swap(nums, j, j+1);
            }
        }

        String res = "";
        if (nums[0] == 0) return "0";
        for (Integer num : nums) {
            res += String.valueOf(num);
        }
        return res;

    }

    public boolean greaterThan(int i, int j) {
        String strI = String.valueOf(i) + String.valueOf(j);
        String strJ = String.valueOf(j) + String.valueOf(i);
        int result = strI.compareTo(strJ);
        if (result > 0) return true;
        else return false;
    }

    public boolean smallerThan(int i, int j) {
        return !(greaterThan(i, j) || equal(i, j));
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public boolean equal(int i, int j) {
        String strI = String.valueOf(i) + String.valueOf(j);
        String strJ = String.valueOf(j) + String.valueOf(i);
        int result = strI.compareTo(strJ);
        if (result == 0) return true;
        else return false;
    }
}
