package Medium;

public class M392IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();
        int cur = 0;
        for(int i = 0; i < lenS; i++) {
            char curS = s.charAt(i);
            boolean found = false;
            while(!found && cur < lenT) {
                if(curS == t.charAt(cur)) {
                    found = true;
                }
                cur++;
            }

            if (!found) return false;
        }
        return true;
    }
}
