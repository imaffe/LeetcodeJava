package Medium;



//import javafx;

import java.util.*;

import static jdk.nashorn.internal.objects.Global.print;

public class AJavaExampleCode {

    // comparator
    public void sort (List<int[]> a) {
        Collections.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return 0;
            }
        });
    }

    public void sort2 (List<List<Integer>> b) {
        Arrays.sort(new int[][]{}, new Comparator<int[]>(){
            @Override
            public int compare(int[] a1, int[] a2) {
                if(a1[0] == a2[0]) {
                    return a1[1] - a2[1];
                } else{
                    return a1[0] - a2[0];
                }
            }
        });
    }

    public void sortMap(List<Map<Integer, Integer>> a) {

    }

    // public void sortMap(int[])

    // quicksort

    // heap implementation : Priority Queue
    public void heap(int nums[], int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(k, new Comparator<int[]>() {
            @Override
            public int compare(int[] point1, int[] point2) {
                int dist1 = point1[0]*point1[0] + point1[1]*point1[1];
                int dist2 = point2[0]*point2[0] + point2[1]*point2[1];
                return dist1 - dist2;
            }
        });
    }
    // array to List
//
//    int[] spam = new int[] { 1, 2, 3 };
//    Arrays.asList(spam)

    public void testStringEqual(){
        String a = "affeisme";
        String b = "affeisme";
        String c = "affeismePLUS";
        String d = new String("affeisme");
        System.out.println(a == b);
        System.out.println(c.substring(0, 8));
        System.out.println(a == c.substring(0,8));
        System.out.println(a == d);
        System.out.println(c.substring(0, 8) == d);
        System.out.println(c.substring(0, 8) == c.substring(0, 8));
    }

    public void testSetOfSet() {
        Set<Integer> intA = new HashSet<>();
        Set<Integer> intB = new HashSet<>();
        Set<Set<Integer>> set = new HashSet<>();
        intA.add(10);
        intB.add(10);
        set.add(intA);
        System.out.println(set.contains(intB));
    }
}
