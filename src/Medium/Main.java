package Medium;


import jdk.internal.util.xml.impl.Pair;
import jdk.nashorn.internal.objects.NativeJSON;

import java.util.*;

public class Main {
    public static void main(String[] args){

        Queue<Integer> queue= new PriorityQueue<>();
        queue.add(3);
        queue.add(5);
        queue.add(1);
        int first = queue.poll();
        TreeNode node0 = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node0.left = node1;
        node0.right = node2;
        node1.left = node3;
        node1.right = node4;

        M398LongestKRepetitiveSubstring sol = new M398LongestKRepetitiveSubstring();


        int array [] = {1,2,3,0,2};
        int array1 [] = {1,7,11};
        int array2 [] = {2,4,6};
        int array2d[][] = {{0,3},{1,3},{2,3},{4,3},{5,4}};
        String stringArray[] = {"abcw","baz","foo","bar","xtfn","abcdef"};
        String expression = "bbaaacbd";
        int res = sol.longestSubstring(expression, 3);
        System.out.println();
    }

}

