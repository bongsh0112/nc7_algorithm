import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main { // 3187 bfs
  
  static int row, col;
  static int[] dirX = {0, 1, 0, -1}; //x축
  static int[] dirY = {1, 0, -1, 0}; //y축
  static String[][] map;
  static boolean[][] check;
  static Queue<int[]> queue = new LinkedList<>();
  static int wolf, sheep;
  
  public static void main(String[] args) throws IOException {
    
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    
    String[] rowCol = bufferedReader.readLine().split(" ");
    row = Integer.parseInt(rowCol[0]);
    col = Integer.parseInt(rowCol[1]);
    
    map = new String[row][col];
    check = new boolean[row][col];
    
    for (int i = 0; i < row; i++) {
      String[] temp = bufferedReader.readLine().split("");
      for (int j = 0; j < col; j++) {
        map[i][j] = temp[j];
      }
    }
    
    wolf = 0; sheep = 0;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (!check[i][j] && !map[i][j].equals("#")) {
          bfs(i, j);
        }
      }
    }
    
    System.out.println(sheep + " " + wolf);
    
  }
  static void bfs(int r, int c) {
    queue.offer(new int[]{r, c});
    check[r][c] = true;
    int tempSheep = 0;
    int tempWolf = 0;
    
    while (!queue.isEmpty()) {
      int curRow = queue.peek()[0];
      int curCol = queue.peek()[1];
      queue.poll();
      
      if (map[curRow][curCol].equals("v")) {
        tempWolf += 1;
      } else if (map[curRow][curCol].equals("k")) {
        tempSheep += 1;
      }
      
      for (int i = 0; i < 4; i++) {
        int R = curRow + dirY[i];
        int C = curCol + dirX[i];
        
        if (R < 0 || C < 0 || R >= row || C >= col) {
          continue;
        }
        if (check[R][C] || map[R][C].equals("#")) {
          continue;
        }
        
        check[R][C] = true;
        queue.offer(new int[]{R, C});
      }
      
    }
    
    if (tempWolf >= tempSheep) {
      wolf += tempWolf;
    } else {
      sheep += tempSheep;
    }
    
  }
  
}