import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  
  static int dirX[] = {0, 0, -1, 1}; // 좌우
  static int dirY[] = {-1, 1, 0, 0}; // 상하
  static int T; // 테스트 케이스의 개수
  static int N, M, K; // 행렬의 행, 열, 심어져있는 배추의 개수
  static int[][] farm;
  static boolean[][] check;
  static int earthWorm;
  
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
            dfs(i, j);
          }
        }
      }
      stringBuffer.append(earthWorm + "\n");
      
    }
    System.out.println(stringBuffer.toString() + "\n");
  }
  
  static void dfs(int x, int y) {
    check[x][y] = true;
    
    for (int i = 0; i < 4; i++) {
      int X = dirX[i] + x;
      int Y = dirY[i] + y;
      
      if (X >= 0 && X < N && Y >= 0 && Y < M) {
        /** 조건문 순서대로
         * X와 Y는 인덱스이므로 0보다 커야하며 맥시멈인 N보다 작아야함.
         * 상하좌우로 체크하는 도중 check가 true인 곳이 나오면 이미 체크한 곳이므로 false인 경우만 고려해야함
         * 아파트가 존재하는 곳이어야 함.
         */
        if (check[X][Y] == false && farm[X][Y] == 1) {
          check[X][Y] = true; // 방문 처리
          
          dfs(X, Y); // 체크한 곳을 X, Y로 삼아 다시 dfs 실행
        }
      }
    }
    
  }
}