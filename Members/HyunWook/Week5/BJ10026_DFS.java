// 10026 적록색약 - DFS

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  static int N;
  static int Count; // 정상
  static int RedGreenColorWeekness; // 적록색약
  static char[][] map;
  static boolean[][] visited;
  static int[] dx = { -1, 1, 0, 0 };
  static int[] dy = { 0, 0, -1, 1 };

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    map = new char[N][N];
    visited = new boolean[N][N];

    for (int i = 0; i < N; i++) {
      String str = br.readLine();
      for (int j = 0; j < str.length(); j++) {
        map[i][j] = str.charAt(j);
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (!visited[i][j]) {
          dfs(i, j);
          Count++;
        }
      }
    }
    // 적록색약은 R과 G가 똑같이 보이므로 R을 G로 바꿔줌
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (map[i][j] == 'R') {
          map[i][j] = 'G';
        }
      }
    }
    // 적록색약은 어떻게 보이는지 알아봐야하기 때문에 방문 체크 배열 초기화
    visited = new boolean[N][N];

    // 적록색약
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (!visited[i][j]) {
          dfs(i, j);
          RedGreenColorWeekness++;
        }
      }
    }
    StringBuilder sb = new StringBuilder();
    sb.append(Count).append(" ").append(RedGreenColorWeekness);

    System.out.println(sb);
  }

  public static void dfs(int x, int y) {
    // 이미 방문했으면 리턴
    if (visited[x][y]) {
      return;
    }
    // 방문 체크
    visited[x][y] = true;

    // 현재색깔
    char temp = map[x][y];

    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if (nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] != temp) {
        continue;
      }
      // 다음 구역도 현재 구역 색과 같으면 dfs 실행
      if (map[nx][ny] == temp) {
        dfs(nx, ny);
      }
    }
  }
}
