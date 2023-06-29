import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  
  static int row, col;
  static int[] dirX = {0, 1, 0, -1}; //x축
  static int[] dirY = {1, 0, -1, 0}; //y축
  static String[][] map;
  static boolean[][] check;
  private static int wolf = 0;
  private static int sheep = 0;
  
  private static int tempSheep = 0;
  private static int tempWolf = 0;
  
  // 얘네를 static 으로 설정한 이유는 재귀를 돌면서 초기화하면 값이 계속 0이 되기 때문에 반영이 안된다.
  
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
    
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (!check[i][j] && !map[i][j].equals("#")) { // 최초 영역 탐색 시 방문하지 않았고 울타리도 아니라면
          tempWolf = 0;
          tempSheep = 0; // 새로운 영역을 찾을 때 temp 변수들을 초기화함.
          dfs(i, j);
          if (tempWolf >= tempSheep) {
            wolf += tempWolf;
          } else {
            sheep += tempSheep;
          }
        }
      }
    }
    
    System.out.println(sheep + " " + wolf);
    
  }
  static void dfs(int r, int c) {
    
    //if (!check[r][c] || !map[r][c].equals("#")) { // queue poll을 받았을 떄는 이 조건을 이미 만족하는 상태인 것을 받는다.
    /** dfs 로직 들어오자마자 방문하지 않았고 울타리가 아닌 것을 체크하는 이유
     * 재귀기 때문에 들어오자마자 [r][c]가 방문된 상태인지, 방문된 상태가 아니라면 울타리인지 확인해야함.
     * BFS로 따지면 queue poll해서 받은 값을 바로 보는것과 같음.
     */
    if (map[r][c].equals("v")) {
      tempWolf++;
    } else if (map[r][c].equals("k")) {
      tempSheep++;
    }
    /**
     * queue에서 poll 받은 것과 동일함. 그래서 바로 양인지 늑대인지 검사할 수 있음.
     */
    //}
    check[r][c] = true; // 양인지 늑대인지 검사가 끝났으니까 방문 처리.
    
    for (int i = 0; i < 4; i++) {
      int R = r + dirY[i]; // row
      int C = c + dirX[i]; // col
      
      if (R < 0 || C < 0 || R >= row || C >= col) {
        continue;
      }
      
      if (!check[R][C] && !map[R][C].equals("#")) { // 상하좌우로 변한 값에 대한 검사
        dfs(R, C);
      }
    }
  }
  
}