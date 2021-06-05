package Medium;

import java.util.ArrayList;
import java.util.List;

public class SF008GetOneBit {
    public int[] getOneBit(int n){
        int bits = 0;
        int cur = n;
        List<Integer> map = new ArrayList<>();
        while(cur != 0) {
            int lastBit = cur % 2;
            if(lastBit == 1) map.add(bits);
            bits++;
            cur = cur / 2;
        }
        int size = map.size();
        int [] result = new int[size];
        for(int i = 0 ; i < size; i++){
            result[i] = bits - map.get(size-i-1);
        }
        return result;
    }
}
