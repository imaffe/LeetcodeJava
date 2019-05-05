package Medium;

import java.util.ArrayList;
import java.util.List;

public class M386LexicographicalNumbers {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        int initPrefix = 0;
        generate(result, initPrefix, n);
        return result;
    }

    private void generate(List<Integer> result, int prefix, int n) {
        if (prefix == 0) {
            int next = 0;
            for (int i = 1; i <= 9; i++) {
                next = prefix * 10 + i;
                if (next <= n) {
                    result.add(next);
                    generate(result,next,n);
                } else break;
            }
        } else {
            int next = 0;
            for (int i = 0; i <= 9; i++) {
                next = prefix * 10 + i;
                if (next <= n) {
                    result.add(next);
                    generate(result,next,n);
                } else break;
            }
        }

    }
}
