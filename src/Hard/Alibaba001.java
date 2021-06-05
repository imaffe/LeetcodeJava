//package Hard;
//
//
//import java.util.*;
//
//    private static int result = 0;
//    private static int[][] map = null;
//    private static int[][] visited = null;
//    private static int row = 0;
//    private static int col = 0;
//    private static int[] start = new int[2];
//    private static int[] end = new int[2];
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int row = sc.nextInt();
//        int col = sc.nextInt();
//        map = new int[row][col];
//        visited = new int[row][col];
//        for(int i = 0 ; i < row;i ++) {
//            String s = sc.next();
//            for(int j = 0; j < col; j++) {
//                int res = 0;
//                if(s.charAt(j) == '，') res = 0;
//                else if(s.charAt(j) == '#') res = -1;
//                else if(s.charAt(j) == 'E') {
//                    res = 2;
//                    end[0] = i;
//                    end[1] = j;
//                }
//                else if(s.charAt(j) == 'S') {
//                    res = 1;
//                    start[0] = i;
//                    start[1] = j;
//                }
//                else System.out.println("invalid parsing");
//
//                map[i][j] = res;
//            }
//        }
//
//        getResult();
//    }
//
//
//    public static void getResult(){
//        List<int[]> q = new ArrayList<>();
//
//        int[] dx = {-1,0,1,0};
//        int[] dy = {0,1,0,-1};
//        // add start to queue, curent len = 0;
//        int cur = 0;
//        int step = 0;
//        q.add(start);
//        while(cur < q.size()){
//            int curSize = q.size();
//            while(cur < curSize) {
//                int[] pos = q.get(cur);
//                // mark visited
//                visited[pos[0]][pos[1]] = step;
//                if(pos[0] == end[0] && pos[1] == end[1]) {
//                    result = step;
//                    return;
//                }
//                int nextX = pos[0];
//                int nextY = pos[1];
//                for(int i = 0 ; i < 4; i++) {
//                    nextX += dx[i];
//                    nextY += dy[i];
//                    if(canGoTo(nextX,nextY)) q.add(new int[]{nextX, nextY});
//                }
//
//                // get mirror;
//                int mirrorX = row - 1 - pos[0];
//                int mirrorY = col - 1 - pos[1];
//
//                if(canGoTo(mirrorX,mirrorY)) q.add(new int[]{nextX, nextY});
//
//                cur++;
//                step++;
//            }
//        }
//    }
//
//    public static boolean canGoTo(int x, int y) {
//        return (x >= 0 && x < row && y >=0 && y< col && map[x][y] >= 0);
//    }
//}
