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

        M406QueueConstructionByHeight sol = new M406QueueConstructionByHeight();


        int array [] = {1,2,3,0,2};
        int array1 [] = {1,7,11};
        int array2 [] = {2,4,6};
        int array2d[][] = {{0,3},{1,3},{2,3},{4,3},{5,4}};
        String stringArray[] = {"abcw","baz","foo","bar","xtfn","abcdef"};
        String expression = "bbaaacbd";
        String [] pair1 = {"x1","x2"};
        String [] pair2 = {"x2","x3"};
        String [] pair3 = {"x3","x4"};
        String [] pair4 = {"x4","x5"};


        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList(pair1));
        equations.add(Arrays.asList(pair2));
        equations.add(Arrays.asList(pair3));
        equations.add(Arrays.asList(pair4));
        List<List<String>> queries = new ArrayList<>();
        String [] query1 = {"x1","x5"};
        queries.add(Arrays.asList(query1));
        double []values = {3.0,4.0,5.0,6.0};
        int [][] queues = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2} };
        int [][] res = sol.reconstructQueue(queues);
        System.out.println();

        // test classes
        TestClass test = new TestClass();
        TestClass.DefaultClass defa = test.new DefaultClass();

        TestClass.ProtectedClass protectedClass = test.new ProtectedClass();


    }

}

