import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  
  static int row, col;
  static int[] dirX = {0, 1, 1, 1, 0, -1, -1, -1};
  static int[] dirY = {1, 1, 0, -1, -1, -1, 0, 1};
  static int[][] map;
  static Queue<int[]> queue = new LinkedList<>();
  
  public static void main(String[] args) throws IOException {
    
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    String[] str = bufferedReader.readLine().split(" ");
    
    row = Integer.parseInt(str[0]);
    col = Integer.parseInt(str[1]);
    map = new int[row][col];
    
    for (int i = 0; i < row; i++) {
      str = bufferedReader.readLine().split(" ");
      for (int j = 0; j < col; j++) {
        map[i][j] = Integer.parseInt(str[j]);
        if (map[i][j] == 1) {
          queue.offer(new int[]{i, j}); // 상어가 있는 곳을 queue에 넣는다
        }
      }
    }
    
    while (!queue.isEmpty()) {
      int[] cur = queue.poll();
      int curRow = cur[0];
      int curCol = cur[1];
      for (int i = 0; i < 8; i++) {
        int C = curCol + dirX[i];
        int R = curRow + dirY[i];
        
        if (R < 0 || C < 0 || R >= row || C >= col) continue;
        
        if (map[R][C] == 0) {
          map[R][C] = map[curRow][curCol] + 1;
          queue.offer(new int[]{R, C});
        }
      }
    }
    
    int max = 0;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (max < map[i][j]) {
          max = map[i][j];
        }
      }
    }
    
    System.out.println(max - 1);
    
  }
}