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
  static int X, Y; // 현재 내 좌표
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
    
    for(int i=0; i<N; i++) {
      for(int j=0; j<N; j++) {
        if(check[i][j] == false && map[i][j] == 1) { // 방문하지 않았고 아파트가 있는 곳을 골라서
          aparts = 0; // 아파트의 개수는 0으로 초기화
          complex++; // 새로운 단지를 찾았으니까 단지 개수는 +1
          dfs(i, j); // dfs 시작
          apartsInComplex.add(aparts); // dfs의 결과로 나온 아파트의 개수를 단지 별로 저장
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
  
  static void dfs(int x, int y) {
    check[x][y] = true; // 방문 처리
    map[x][y] = complex; // 단지 번호로 아파트 이름 mark
    aparts++; // 단지 별 아파트 개수 + 1
    
    for(int i=0; i<4; i++) {
      X = dirX[i] + x;
      Y = dirY[i] + y;
      /**
       * 상하좌우로 체크하기
       */
      
      if((X >= 0 && X < N && Y >= 0 && Y < N) && check[X][Y] == false && map[X][Y] == 1) {
        /** 조건문 순서대로
         * X와 Y는 인덱스이므로 0보다 커야하며 맥시멈인 N보다 작아야함.
         * 상하좌우로 체크하는 도중 check가 true인 곳이 나오면 이미 체크한 곳이므로 false인 경우만 고려해야함
         * 아파트가 존재하는 곳이어야 함.
         */
        check[X][Y] = true; // 방문 처리
        map[X][Y] = complex; // 방문한 곳은 단지 이름으로 mark
        
        dfs(X, Y); // 체크한 곳을 X, Y로 삼아 다시 dfs 실행
      }
    }
    
  }
  
}