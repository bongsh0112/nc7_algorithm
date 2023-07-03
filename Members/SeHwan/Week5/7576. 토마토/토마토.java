import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  
  static int row, col;
  static int[] dirX = {0, 1, 0, -1}; //x축
  static int[] dirY = {1, 0, -1, 0}; //y축
  static int[][] box;
  static boolean[][] check;
  
  static Queue<int[]> queue = new LinkedList<>();
  
  public static void main(String[] args) throws IOException {
    
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    
    String[] str = bufferedReader.readLine().split(" ");
    col = Integer.parseInt(str[0]);
    row = Integer.parseInt(str[1]);
    
    box = new int[row][col];
    check = new boolean[row][col];
    
    for (int i = 0; i < row; i++) {
      String[] temp = bufferedReader.readLine().split(" ");
      for (int j = 0; j < col; j++) {
        box[i][j] = Integer.parseInt(temp[j]);
        if (box[i][j] == 1) {
          queue.offer(new int[]{i, j});
          // ** 처음부터 익어있는 것을 queue에 저장 **
          // queue에 들어가는 배열은 row(y축), col(x축) 꼴이다.
        }
      }
    }
    
    System.out.println(bfs());
    
  }
  static int bfs() {
    /**
     * Queue가 빌 때 까지 돌리는데, 예전에 어떤 문제에서 처럼 탐색이 진행될 때 마다
     * box의 숫자가 1씩 늘어나게 하여 토마토가 모두 익을 때 까지 걸리는 시간을 계산한다.
     * 예제 3번처럼 처음부터 익은 토마토가 두개 이상이라면, 양쪽에서 범위를 좁혀올 수 있을 것이다.
     * queue기 -선입선출- 이라는 특징을 가지기 때문에 양쪽에서 범위를 좁힐 수 있는 것이다.
     * 예제 3번을 생각해보면 (0, 0), (3, 5)를 시작점으로 하는데 (0, 0)에서 파생된 것이 (3, 5) 뒤에 들어가기 때문에
     * (3, 5)를 (0, 0) 다음에 체크할 수 있는 것이다.
     * 마지막에 1을 빼주는 것을 잊지말자.
     */
    while (!queue.isEmpty()) {
      
      int[] cur = queue.poll();
      int curCol = cur[1];
      int curRow = cur[0];
      for (int i = 0; i < 4; i++) {
        int C = curCol + dirX[i];
        int R = curRow + dirY[i];
        
        if (R < 0 || C < 0 || R >= row || C >= col) continue;
        
        if (box[R][C] == 0) {
          box[R][C] = box[curRow][curCol] + 1;
          queue.offer(new int[]{R, C});
        }
        
      }
    }
    
    int max = 0;
    if (noRipeTomato()) {
      /**
       * 한 칸이라도 0이라면?? 모두 익지 못하는 상황인 것이다.
       */
      return -1;
    } else {
      for (int i = 0; i < row; i++) {
        for (int j = 0; j < col; j++) {
          if (box[i][j] > max) {
            max = box[i][j];
          }
        }
      }
      return max - 1;
    }
  }
  
  static Boolean noRipeTomato() {
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (box[i][j] == 0) { // 한 칸이라도 0이라면?? 모두 익지 못하는 상황인 것이다.
          return true;
        }
      }
    }
    return false;
  }
  
}