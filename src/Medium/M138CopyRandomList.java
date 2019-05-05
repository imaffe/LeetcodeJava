package Medium;

public class M138CopyRandomList {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int [] net = new int[len];
        for (int i = 0 ; i < len; i++) {
            net[i] = gas[i] - cost[i];
        }
        int ans = -1;
        for (int i = 0 ; i < len; i++) {
            int left = 0;
            int cur = 0;
            boolean result = true;
            for (int j = 0; j < len; j++) {
                left += net[(i +  j) % len];
                if (left < 0) {
                    result = false;
                    break;
                }
            }

            if (result) {
                ans = i;
                break;
            }
        }
        return ans;
    }
}
