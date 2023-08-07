import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  
  static int[] dirX = new int[]{0, 1, 0, -1};
  static int[] dirY = new int[]{1, 0, -1, 0};
  static int N;
  static int[][] map;
  static boolean[][] checked;
  
  public static void main(String[] args) throws IOException {
    
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(bufferedReader.readLine());
    
    map = new int[N][N];
    
    int max = 0;
    for (int i = 0; i < N; i++) {
      String[] str = bufferedReader.readLine().split(" ");
      for (int j = 0; j < N; j++) {
        int tmp = Integer.parseInt(str[j]);
        map[i][j] = tmp;
        if (tmp > max) max = tmp;
      }
    }
    
    int maxCount = 0;
    for (int height = 0; height < max + 1; height++) { // 0 ~ 최대 높이까지 강수량을 올려가며 탐색한다
      checked = new boolean[N][N];
      int count = 0;
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          if (!checked[i][j] && map[i][j] > height) {
            dfs(i, j, height);
            count++; // dfs를 한번 다 돌면 구역이 나타날 것. 이 때 count++
          }
        }
      }
      maxCount = Math.max(maxCount, count); // 정해진 height에서 나온 구역과 이전까지의 최댓값을 비교하여 maxCount 얻어내기
    }
    
    System.out.println(maxCount);
    
  }
  
  static void dfs(int x, int y, int height) {
  
    checked[x][y] = true;
    for (int i = 0; i < 4; i++) {
      int curX = x + dirX[i];
      int curY = y + dirY[i];
      
      if (curX >= 0 && curY >= 0 && curX < N && curY < N && !checked[curX][curY] && map[curX][curY] > height) {
        dfs(curX, curY, height);
      }
    }
    
  }
  
}