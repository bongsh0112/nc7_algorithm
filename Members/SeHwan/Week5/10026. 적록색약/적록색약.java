

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  
  static int N;
  static int[] dirX = {0, 1, 0, -1}; //x축
  static int[] dirY = {1, 0, -1, 0}; //y축
  static String[][] grid;
  static boolean[][] check;
  static int area;
  
  static Queue<int[]> queue = new LinkedList<>();
  
  public static void main(String[] args) throws IOException {
    
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer stringBuffer = new StringBuffer();
    
    N = Integer.parseInt(bufferedReader.readLine());
    
    grid = new String[N][N];
    check = new boolean[N][N];
    
    for (int i = 0; i < N; i++) {
      String[] temp = bufferedReader.readLine().split("");
      for (int j = 0; j < N; j++) {
        grid[i][j] = temp[j];
      }
    }
    
    // 일반인 -> 다음 색약 보유자 설정을 위해 G -> R 로 변경
    for (int i = 0; i < N; i++) { // row
      for (int j = 0; j < N; j++) { // col
        if (!check[i][j]) {
          dfs(i, j, grid[i][j]);
          area++;
        }
        if (grid[i][j].equals("G")) {
          grid[i][j] = "R";
        }
      }
    }
    stringBuffer.append(area + " ");
    
    // 색약 보유자
    area = 0;
    check = new boolean[N][N];
    for (int i = 0; i < N; i++) { // row
      for (int j = 0; j < N; j++) { // col
        if (!check[i][j]) {
          dfs(i, j, grid[i][j]);
          area++;
        }
      }
    }
    stringBuffer.append(area);
    
    System.out.println(stringBuffer.toString());
    
  }
  static void dfs(int r, int c, String target) { // 현재 탐색중인 색깔만을 계속해서 탐색하게 한다.
    if (!check[r][c]) {
      check[r][c] = true;
      
      for (int i = 0; i < 4; i++) {
        int C = c + dirX[i];
        int R = r + dirY[i];
        
        if (R >= 0 && C >= 0 && R < N && C < N && grid[R][C].equals(target)) {
          dfs(R, C, target);
        }
      }
    }
  }
  
}