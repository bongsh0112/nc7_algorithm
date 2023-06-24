package Members.DongYoung.Week4;


import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class BOJ_3187 {

    static int[][] adjArr;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};
    static int sheep = 0;
    static int wolf = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String str = scanner.nextLine();

        int N = Integer.parseInt(str.split(" ")[0]);
        int M = Integer.parseInt(str.split(" ")[1]);
        adjArr = new int [N][M];
        for(int i = 0; i < N; i++) {
            str= scanner.nextLine();
            for(int j = 0; j < M; j++) {
                if (str.charAt(j) == '.') {
                    adjArr[i][j] = 1; // 비어있음
                } else if (str.charAt(j) == '#') {
                    adjArr[i][j] = 0; // 울타리
                } else if (str.charAt(j) == 'v') {
                    adjArr[i][j] = 2; // 늑대
                } else if (str.charAt(j) == 'k') {
                    adjArr[i][j] = 3; // 양
                }
                
            }
        }
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                bfs(i,j);
            }
        }
        System.out.printf("%d %d",sheep,wolf);


    }
    static void bfs(int y, int x) {
        if(adjArr[y][x] == 0) {
            return;
        }
        int sheepNum = 0;
        int wolfNum = 0;
        int XMax = adjArr[0].length;
        int YMax = adjArr.length;
        Queue<xy> queue = new LinkedList<>();
        queue.offer(new xy(y,x));
        if(adjArr[y][x] == 2) {
            wolfNum++;
        } else if (adjArr[y][x] == 3) {
            sheepNum ++;
        }
        adjArr[y][x] = 0;

        while(!queue.isEmpty()) {
            xy now = queue.poll();
            for(int i = 0; i < 4; i++) {
                int x1 = now.x + dx[i];
                int y1 = now.y + dy[i];
                if (x1 >= 0 && x1 <XMax && y1 >= 0 && y1 <YMax) {
                    if(adjArr[y1][x1] != 0) {
                         if(adjArr[y1][x1] == 2) {
                            wolfNum++;
                        } else if (adjArr[y1][x1] == 3) {
                            sheepNum ++;
                        }
                        adjArr[y1][x1] = 0;
                        queue.offer(new xy(y1,x1));
                    }
                }
            }
        }
        if(wolfNum >= sheepNum) {
            wolf += wolfNum;
        } else {
            sheep += sheepNum;
        }

    }

    static class xy {
        int x;
        int y;
        public xy(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }
}
