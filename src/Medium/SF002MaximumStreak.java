package Medium;

public class SF002MaximumStreak {
    public int maxStreak(int n, String[] date) {

        int days = date[0].length();
        int[] res = new int[days];
        for(int i = 0; i < days; i++){
            int result = 1;
            for(int j = 0 ; j < n; j++) {
                if(date[j].charAt(i) == 'N') {
                    result = 0;
                    break;
                }
            }
            res[i] = result;
        }
        int count = 0;
        int max = 0;
        for(int i = 0 ; i < days; i++) {
            if(res[i] == 0) {
                count = 0;
            } else{
                count ++;
                if(count > max) max = count;
            }
        }
        return max;
    }
}
