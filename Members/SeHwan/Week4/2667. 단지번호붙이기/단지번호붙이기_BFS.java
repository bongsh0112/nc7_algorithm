import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  
  static int dirX[] = {0, 0, -1, 1}; // 좌우
  static int dirY[] = {-1, 1, 0, 0}; // 상하
  static int N; // map의 크기
  static int complex; // 단지의 개수
  static int aparts; // 단지 내 아파트의 개수
  static List<Integer> apartsInComplex = new ArrayList<>(); // 단지 내 아파트의 개수
  static int[][] map; // 입력받은 지도
  static boolean[][] check;
  static Queue<int[]> queue = new LinkedList<>(); // 배열을 원소로 갖는 링크드리스트 선언
  
  public static void main(String[] args) throws IOException {
    
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer stringBuffer = new StringBuffer();
    
    N = Integer.parseInt(bufferedReader.readLine());
    map = new int[N][N];
    check = new boolean[N][N];
    
    for (int i = 0; i < N; i++) {
      String[] str = bufferedReader.readLine().split("");
      for (int j = 0; j < str.length; j++) {
        map[i][j] = Integer.parseInt(str[j]);
      }
    }
    
    for(int i = 0; i < N; i++){
      for(int j = 0; j < N; j++){
        aparts = 0;
        if(map[i][j] == 1 && !check[i][j]){
          complex++;
          bfs(i,j);
          apartsInComplex.add(aparts);
        }
      }
    }
    
    Collections.sort(apartsInComplex);
    stringBuffer.append(complex + "\n");
    for(int aparts : apartsInComplex) {
      stringBuffer.append(aparts + "\n");
    }
    
    System.out.println(stringBuffer.toString());
    
  }
  
  static void bfs(int x, int y) {
    queue.add(new int[]{x, y});
    check[x][y] = true;
    map[x][y] = complex;
    aparts++;
    
    while (!queue.isEmpty()) {
      int curX = queue.peek()[0];
      int curY = queue.peek()[1];
      queue.poll();
      
      for(int i = 0; i < 4; i++){
        int X = curX + dirX[i];
        int Y = curY + dirY[i];
        
        if(X >= 0 && Y >= 0 && X < N && Y < N){
          if(map[X][Y] == 1 && !check[X][Y]){
            queue.add(new int[]{X,Y});
            check[X][Y] = true;
            map[X][Y] = complex;
            aparts++;
          }
        }
      }
    }
  }
  
}
