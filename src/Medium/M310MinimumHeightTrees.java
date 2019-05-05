package Medium;

import java.util.*;

public class M310MinimumHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n ; i ++) {
            graph.add(new ArrayList<>());
        }

        int [] degree = new int[n];
        for (int i = 0; i < edges.length; i++) {
            int p1 = edges[i][0];
            int p2 = edges[i][1];
            graph.get(p1).add(p2);
            graph.get(p2).add(p1);
            degree[p1]++;
            degree[p2]++;
        }

        List<Integer> leaves = new ArrayList<>();
        boolean found = false;
        boolean []visited = new boolean[n];
        for (int i = 0 ; i < n; i++) visited[i] = false;
        List<Integer> result = new ArrayList<>();
        while (!found) {
            leaves.clear();
            result.clear();


            int left  = 0;
            for (int i = 0 ; i < n; i++) {
                if (visited[i] == false) {
                    left ++;
                    result.add(i);
                }
            }

            for (int i = 0 ; i < n; i++) {
                if (degree[i] == 1){
                    leaves.add(i);
                    visited[i] = true;
                }
            }




            if (left <= 2) {
                found = true;
            } else {
                for (int i = 0 ; i < leaves.size(); i++) {
                    int leave = leaves.get(i);
                    degree[leave]--;
                    for(int j = 0; j < graph.get(leave).size(); j++){
                        int neibor = graph.get(leave).get(j);
                        degree[neibor]--;
                    }
                }
            }
        }
        return result;
    }
}
