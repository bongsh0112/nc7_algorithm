package Members.DongYoung.Week4;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;


public class BOJ_4963 {

    static int [][] adjArr;
    static int[] dx= {0,1,1,1,0,-1,-1,-1};//시계방향으로 방향 순서
    static int[] dy = {-1,-1,0,1,1,1,0,-1};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String str;
        String answer = "";
        while(true) {
            str = scanner.nextLine();
            int N = Integer.parseInt(str.split(" ")[1]);
            int M = Integer.parseInt(str.split(" ")[0]);
            if(N == 0 && M == 0) {
                break;
            }
            adjArr = new int[N][M];
            for(int i = 0; i < N; i++) {
                str = scanner.nextLine();
                String[] splitList = str.split(" ");
                for(int j = 0; j < M; j++) {
                    adjArr[i][j] = splitList[j].charAt(0) == '1' ? 1 : 0;
                }
            }
            int cnt = 0;
            for(int i = 0; i < adjArr.length;i++) {
                for(int j = 0; j < adjArr[0].length;j++) {
                    if(bfs(i,j)) {
                        cnt ++;
                    }
                }
            }
            answer += cnt + "\n";
        }
        scanner.close();
        System.out.print(answer);
        

    }

    static boolean bfs(int y, int x) {
        if(adjArr[y][x] == 0) {
            return false;
        }
        int XMax = adjArr[0].length;
        int YMax = adjArr.length;
        Queue<xy> queue = new LinkedList<>();
        queue.offer(new xy(y,x));
        adjArr[y][x] = 0;
        while(!queue.isEmpty()) {
            xy now = queue.poll();
            for(int i = 0; i < 8; i++) {
                int x1 = now.x + dx[i];
                int y1 = now.y + dy[i];
                if(x1 >=0 && x1 < XMax && y1 >=0 && y1 < YMax ) {
                    if(adjArr[y1][x1] == 1) {
                        queue.offer(new xy(y1, x1));
                        adjArr[y1][x1] = 0;
                    }
                    
                }
            }
        }
        return true;
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
