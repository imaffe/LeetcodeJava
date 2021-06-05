//package Hard;
//
//
//import java.util.*;
//public class Main {
//
//    private static int len = 0;
//
//    private static TreeMap<Character, List<String>> map;
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        map = new TreeMap<>();
//        int len = sc.nextInt();
//        for(int i  = 0 ; i < len; i++) {
//            String s = sc.next();
//            map.getOrDefault(getStart(s), new ArrayList<>()).add(s);
//        }
//        for(List<String> list : map.values()) {
//            Collections.sort(list, new Comparator<String>() {
//                @Override public int compare(String s, String t1) {
//                    return getEnd(s) - getEnd(t1);
//                }
//            });
//        }
//
//        getMax(map.firstKey());
//    }
//
//    public static char getStart(String s) {
//        return s.charAt(0);
//    }
//
//    public static char getEnd(String s){
//        return s.charAt(s.length()-1);
//    }
//
//    public static void getMax(char from){
//        List<String> toExam = new ArrayList<>();
//        // add all concerned to this
//        List<String> concern = map.get(from);
//
//    }
//
//
//
//
//}
