package Members.DongYoung.Week4;


import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;
public class BOJ_2178 {

    static int[][] adjArr;
    static boolean[][] visited;
    static int[][] lenMap;
    static int [] dx = {0,1,0,-1};
    static int [] dy = {-1,0,1,0};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int N = Integer.parseInt(str.split(" ")[0]);
        int M = Integer.parseInt(str.split(" ")[1]);   

        adjArr = new int[N+1][M+1];
        lenMap = new int[N+1][M+1];
        visited = new boolean [N+1][M+1];
        for(int i = 0; i < N; i++) {
            str = scanner.nextLine();
            for(int j = 0; j < M;j++) {
                adjArr[i+1][j+1] = str.charAt(j) == '1' ? 1 : 0;
            }
        }
        bfs();
        System.out.println(lenMap[N][M]);
        scanner.close();
    }
    
    static void bfs() {
        xy start = new xy(1,1,1);
        Queue<xy> queue = new LinkedList<>();
        visited[1][1] = true;
        lenMap[1][1] = 1;
        queue.offer(start);
        int YMax = adjArr.length;
        int XMax = adjArr[0].length;
        while(!queue.isEmpty()) {
            xy now = queue.poll();
            int x = now.x;
            int y = now.y;
            for(int i = 0; i < 4; i++) {
                int x1 = x + dx[i];
                int y1 = y + dy[i];
                if (x1 >  0 && x1 < XMax && y1 > 0 && y1 < YMax  ) {
                    if(adjArr[y1][x1] ==1 && !visited[y1][x1]) {
                        queue.offer(new xy(x1,y1,now.length + 1));
                        visited[y1][x1] = true;
                        lenMap[y1][x1] = now.length + 1;
                    }
                }
            }
        }
    }
    static public class xy {
        public int x;
        public int y;
        public int length;
        public xy(int x, int y, int length) {
            this.x =x;
            this.y = y;
            this.length = length;
            
        }
    }
}
