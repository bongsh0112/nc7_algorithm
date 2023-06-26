import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  private static int M, N, K; // 배추밭 가로, 세로, 심어진 갯수

  // 지도, 방문 저장 변수
  private static boolean[][] map;
  private static boolean[][] visited;

  private static int[] dx = { 0, 0, 1, -1 };
  private static int[] dy = { 1, -1, 0, 0 };

  public static void main(String[] args) throws Exception {
    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());

    // 실행횟수
    for (int i = 0; i < T; i++) {
      int bugCnt = 0;
      String[] MNK = br.readLine().split(" ");
      M = Integer.parseInt(MNK[0]);
      N = Integer.parseInt(MNK[1]);
      K = Integer.parseInt(MNK[2]);

      // 혹시나 모른 초기화
      map = new boolean[N][M];
      visited = new boolean[N][M];
      for (int j = 0; j < N; j++) {
        Arrays.fill(map[j], false);
        Arrays.fill(visited[j], false);
      }

      // Map그리기
      String[] line = null;
      for (int j = 0; j < K; j++) {
        line = br.readLine().split(" ");
        int y = Integer.parseInt(line[1]);
        int x = Integer.parseInt(line[0]);
        map[y][x] = true;
      }

      for (int y = 0; y < N; y++) {
        for (int x = 0; x < M; x++) {
          if (!visited[y][x] && map[y][x]) {
            bugCnt++;
            dfs(y, x);
          }
        }
      }
      sb.append(bugCnt + "\n");
    }
    System.out.println(sb);
  }

  private static void dfs(int y, int x) {
    visited[y][x] = true;
    for (int i = 0; i < dx.length; i++) {
      int tx = x - dx[i];
      int ty = y - dy[i];

      if ((tx >= 0 && tx < M && ty >= 0 && ty < N) && !visited[ty][tx] && map[ty][tx]) {
        dfs(ty, tx);
      }
    }

  }
}