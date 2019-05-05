package Medium;

public class M213HouseRobber {
    public int rob1(int[] nums) {
        int length = nums.length;


        int cur = 0;
        boolean [] robbed = new boolean[length];
        boolean [] visit = new boolean[length];
        int []result = new int[2];
        doRob(cur, nums, visit, robbed, result);
        return result[0];
    }

    public void doRob(int cur, int[] nums, boolean []visit, boolean[] robbed, int[] result) {
        if (cur < nums.length && !robbed[(cur + 1) % nums.length]) {
            robbed[cur] = true;
            result[1] = result[1] + nums[cur];
            if (result[1] > result[0]) result[0] = result[1];

            doRob((cur + 2), nums, visit,robbed, result);
            undoRob(cur, nums,  robbed, result);
            doRob((cur + 1), nums, visit, robbed, result);
        }
    }

    public void undoRob(int cur, int[] nums, boolean[] robbed, int []result) {
        if (cur >= nums.length || robbed[(cur + 1) % nums.length]) return;
        robbed[cur] = false;
        result[1] = result[1] - nums[cur];
    }
    // TODO backtracking is too slow

    public int rob2(int[] nums) {
        int length = nums.length;
        boolean [] robbed = new boolean[length];
        boolean [] visit = new boolean[length];
        int []result = new int[2];
        doRob1(0, nums, robbed,  result);
        undoRob(0, nums, robbed, result);
        doRob1(1, nums, robbed,  result);
        undoRob(1, nums, robbed,  result);
        doRob1(2, nums, robbed,  result);
        return result[0];
    }

    public void doRob1(int cur, int[] nums, boolean [] robbed, int[] result) {
        if (cur < nums.length && !robbed[(cur + 1) % nums.length]) {
            robbed[cur] = true;
            result[1] = result[1] + nums[cur];
            if (result[1] > result[0]) result[0] = result[1];

            doRob1(cur + 2, nums,  robbed, result);
            undoRob(cur + 2, nums,  robbed, result);
            doRob1(cur + 3, nums, robbed, result);
            undoRob(cur + 3, nums,  robbed, result);
        }
    }

    // above is one solution





    public int rob(int [] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0];
        if (len == 2) return Math.max(nums[0], nums[1]);
        return Math.max(robOne(nums,0, len -2) , robOne(nums, 1, len - 1));
    }





    public int robOne(int [] nums, int low, int high) {
        int len = high - low;
        int [] include = new int[len];
        int [] exclude = new int[len];
        if (len == 0) return 0;
        if (len == 1) return nums[low];
        if (len == 2) return Math.max(nums[low], nums[low + 1]);

        include[0] = nums[low];
        exclude[0] = 0;
        for (int i = 1 ; i < len; i++) {
            include[i] = exclude[i - 1] + nums[i];
            exclude[i] = Math.max(include[i - 1], exclude[i-1]);
        }
        return Math.max(exclude[len - 1], include[len-1]);
    }
}
