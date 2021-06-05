package Medium;

import sun.security.util.math.intpoly.IntegerPolynomialP384;

import java.util.*;
import java.util.stream.Collectors;

public class AmzHighFreq002MaxRope {
    public int minCost(int [] ropes) {
        int len = ropes.length;
        // Huffman Encoding
        if (ropes.length == 1) return 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        List<Integer> list =  Arrays.stream(ropes).boxed().collect( Collectors.toList() );
        queue.addAll(list);

        while (queue.size() > 1) {
            int a = queue.poll();
            int b = queue.poll();
            int combine = a + b;
            queue.add(combine);
        }
        return queue.peek();
    }
}
