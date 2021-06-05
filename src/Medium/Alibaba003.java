//import java.math.BigInteger;
//import java.util.Scanner;
//import java.util.*;
//
//public class Main {
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] L = new int[n];
//        int[] R = new int[n];
//        for(int i = 0 ; i < n; i++) {
//            L[i] = sc.nextInt();
//        }
//        for(int i = 0 ; i < n; i++) {
//            R[i] = sc.nextInt();
//        }
//
//        double result = calculate(L, R, n);
//        System.out.println(result);
//    }
//
//
//    public static double calculate(int[] L, int[] R , int n) {
//        // range of all possible value
//        int minMin = 3000;
//        int minMax = 3000;
//        int[] size = new int[n];
//        double expectation = 0;
//        for(int i = 0 ; i < n ; i++) {
//            if(L[i] < minMin) minMin = L[i];
//            if(R[i] < minMax) minMax = R[i];
//            size[i] = R[i] - L[i] + 1;
//        }
//
//        for(int min = minMin; min <= minMax; min++) {
//            // calculate how many contains i
//            List<Integer> concern = new ArrayList<>();
//            for(int i = 0 ; i < n; i++) {
//                if(L[i] <= min && R[i] >= min) {
//                    concern.add(i);
//                }
//            }
//            // calculate how many cases in this scenario
//            long allMult = 1;
//            long largeThanMinMult = 1;
//            long largeEqualThanMinMult = 1;
//            for(Integer con : concern) {
//                allMult *= size[con];
//                int largeThanMin = R[con] - min;
//                largeThanMinMult *= largeThanMin;
//                int largeEqualThanMin = R[con] - min + 1;
//                largeEqualThanMinMult *= largeEqualThanMin;
//            }
//
//            double res = min * (largeEqualThanMinMult - largeThanMinMult) / allMult;
//            expectation += res;
//        }
//        return expectation;
//    }
//
//}