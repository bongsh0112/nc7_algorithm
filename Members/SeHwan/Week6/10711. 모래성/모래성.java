import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.InterfaceAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  
  static int H;
  static int W;
  static int[] dirX = {0, 1, 1, 1, 0, -1, -1, -1};
  static int[] dirY = {1, 1, 0, -1, -1, -1, 0, 1};
  static Queue<int[]> queue = new LinkedList<>(); // 비어있는 자리를 저장하는 큐
  public static void main(String[] args) throws IOException {
    
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    
    String[] str = bufferedReader.readLine().split(" ");
    H = Integer.parseInt(str[0]);
    W = Integer.parseInt(str[1]);
    
    String[][] map = new String[H][W];
    
    // 모래가 빈 부분에서 8방향으로 나아가는 bfs를 진행할 것 -> 빈 부분을 큐에 넣고 체크하지 않은 빈 부분이 없을 때 까지 반복
    for (int i = 0; i < H; i++) {
      str = bufferedReader.readLine().split("");
      for (int j = 0; j < W; j++) {
        map[i][j] = str[j];
        if (map[i][j].equals(".")) {
          int[] tempArr = new int[]{i, j};
          queue.add(tempArr);
        }
      }
    }
    
    int count = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      
      for (int i = 0; i < size; i++) {
        int[] cur = queue.poll();
        
        for (int j = 0; j < 8; j++) {
          int curH = cur[0] + dirX[j];
          int curW = cur[1] + dirY[j];
          
          if (curH >= 0 && curW >= 0 && curH < H && curW < W) {
            if (!map[curH][curW].equals(".")) {
              map[curH][curW] = String.valueOf(Integer.parseInt(map[curH][curW]) - 1); // . 이던 장소에서의 8방향을 따져봤을 때 모래성이 있던 곳이라면 단단함 -1
              if (map[curH][curW].equals("0")) {
                map[curH][curW] = "."; // 비어버린 모래성의 자리를 구조물이 없던 것으로 판단하도록 바꿔주고 (꼭 필요하진 않음)
                queue.add(new int[]{curH, curW}); // 큐에 좌표를 넣어준다.
              }
            }
          }
        }
      }
      count++; // 반복문을 돌때마다 채운 큐를 모두 비우면 사라지는 모래성이 있을 것. 또한 큐에 원래 들어있던 .나 이전 단계에서 없어진 모래성의 자리는 poll로 없어지기 때문에 가능하다. 그림으로 설명
    }
    System.out.println(count - 1); // 마지막의 큐에서는 사라지는 모래성이 없을테니 -1
  }
}