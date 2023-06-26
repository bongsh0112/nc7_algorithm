import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  
  static int N, M; // 도착지점이자 행렬의 행, 열
  static int dirX[] = {0, 0, -1, 1}; // 좌우
  static int dirY[] = {-1, 1, 0, 0}; // 상하
  static int[][] maze;
  static boolean[][] check;
  static int count;
  static Queue<int[]> queue = new LinkedList<>();
  
  public static void main(String[] args) throws IOException {
    
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    
    String[] str = bufferedReader.readLine().split(" ");
    N = Integer.parseInt(str[0]);
    M = Integer.parseInt(str[1]);
    maze = new int[N][M];
    for (int i = 0; i < N; i++) {
      str = bufferedReader.readLine().split("");
      for (int j = 0; j < M; j++) {
        int temp = Integer.parseInt(str[j]);
        maze[i][j] = temp;
      }
    }
    
    check = new boolean[N][M];
    count = 0;
    bfs(0, 0);
    System.out.println(maze[N-1][M-1]); // 마지막 칸에서 증가시킨 count는 제외한다
  }
  
  static void bfs(int x, int y) {
    queue.add(new int[]{x, y});
    check[x][y] = true;
    
    while (!queue.isEmpty()) {
      int curX = queue.peek()[0];
      int curY = queue.peek()[1];
      queue.poll();
      
      for(int i = 0; i < 4; i++) {
        int X = curX + dirX[i];
        int Y = curY + dirY[i];
        
        if (X >= 0 && Y >= 0 && X < N && Y < M) {
          if (maze[X][Y] == 1 && !check[X][Y]) {
            queue.add(new int[]{X, Y});
            check[X][Y] = true;
            maze[X][Y] = maze[curX][curY] + 1; // count로 단순히 증가시키는 것은 불필요한 길도 세기 때문에 미로 배열 자체의 값을 뽑아야 한다.
          }
        }
      }
    }
  }
}