package Hard;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class ByteDanceLRU {

    Queue<Integer> queue;
    int capacity;
    Map<Integer, Integer> cache;

    public ByteDanceLRU(int capacity) {
        this.queue = new ArrayDeque<>();
        this.capacity = capacity;
        this.cache = new HashMap<>();
    }
    public int get(int key){
        if(cache.containsKey(key)) {
            queue.remove(key);
            queue.add(key);
            return cache.get(key);
        } else return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.put(key, value);
            queue.remove(key);
            queue.add(key);
        } else {
            if (cache.size() < capacity) {
                cache.put(key, value);
                queue.remove(key);
            } else {
                int victim = queue.poll();
                cache.remove(victim);
                cache.put(key, value);
                queue.add(key);
            }
        }
    }
}
