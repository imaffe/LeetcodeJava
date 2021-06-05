package Medium;

public class CT1584 {
    int[] pair;
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {

        pair = new int[n];
        for(int i = 0 ; i < n/2; i++) {
            int[] onePair = pairs[i];
            pair[onePair[0]] = onePair[1];
            pair[onePair[1]] = onePair[0];
        }

        int[] happy = new int[n];
        for (int i = 0 ; i < n ; i ++) {
            if(happy[i] == 1) continue;
            int curPair = pair[i];
            int index = findInPreference(preferences[i], curPair);
            boolean notHappy = false;
            for(int j = 0 ; j < index; j ++) {
                notHappy = checkNotHappy(preferences, preferences[i][j], i);
                if(notHappy) {
                    happy[i] = 1;
                    happy[preferences[i][j]] = 1;
                    break;
                }
            }
        }
        int cnt = 0;
        for(int i = 0 ; i < n; i++) {
            if(happy[i] == 1) {
                cnt ++;
            }
        }
        return cnt;
    }

    public int findInPreference(int[] prefer, int target) {
        for (int i = 0 ; i < prefer.length; i++) {
            if(prefer[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public boolean checkNotHappy(int[][] prefers, int lover, int target) {
        int loverPair = pair[lover];
        int index = findInPreference(prefers[lover], loverPair);
        int targetIndex = findInPreference(prefers[lover], target);
        if (targetIndex < index) return true;
        else return false;
    }

    public static void main(String[] args) {
        int [][] prefer = new int[][]{{1,2,3},{3,2,0},{3,1,0},{1,2,0}};
        int [][] pairs = new int[][]{{0,1},{2,3}};
        CT1584 sol  = new CT1584();
        sol.unhappyFriends(4, prefer, pairs);
    }
}
