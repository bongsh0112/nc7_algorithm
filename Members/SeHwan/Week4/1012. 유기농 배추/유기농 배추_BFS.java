import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  
  static int dirX[] = {0, 0, -1, 1}; // 좌우
  static int dirY[] = {-1, 1, 0, 0}; // 상하
  static int T; // 테스트 케이스의 개수
  static int N, M, K; // 행렬의 행, 열, 심어져있는 배추의 개수
  static int[][] farm;
  static boolean[][] check;
  static int earthWorm;
  static Queue<int[]> queue = new LinkedList<>(); // 배열을 원소로 갖는 링크드리스트 선언
  
  public static void main(String[] args) throws IOException {
    
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer stringBuffer = new StringBuffer();
    
    T = Integer.parseInt(bufferedReader.readLine());
    
    for (int t = 0; t < T; t++) {
      String[] str = bufferedReader.readLine().split(" ");
      N = Integer.parseInt(str[0]);
      M = Integer.parseInt(str[1]);
      K = Integer.parseInt(str[2]);
      farm = new int[N][M];
      
      for (int i = 0; i < K; i++) {
        str = bufferedReader.readLine().split(" ");
        int x = Integer.parseInt(str[0]);
        int y = Integer.parseInt(str[1]);
        farm[x][y] = 1;
      }
      
      check = new boolean[N][M];
      earthWorm = 0;
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
          if (check[i][j] == false && farm[i][j] == 1) {
            earthWorm++;
            bfs(i, j);
          }
        }
      }
      stringBuffer.append(earthWorm + "\n");
      
    }
    System.out.println(stringBuffer.toString() + "\n");
  }
  
  static void bfs(int x, int y) {
    queue.offer(new int[]{x, y});
    check[x][y] = true;
    
    while (!queue.isEmpty()) {
      int curX = queue.peek()[0];
      int curY = queue.peek()[1];
      queue.poll();
      
      for(int i = 0; i < 4; i++){
        int X = curX + dirX[i];
        int Y = curY + dirY[i];
        
        if(X >= 0 && Y >= 0 && X < N && Y < M){
          if(farm[X][Y] == 1 && !check[X][Y]){
            queue.add(new int[]{X,Y});
            check[X][Y] = true;
          }
        }
      }
    }
  }
}