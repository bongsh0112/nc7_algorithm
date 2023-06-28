import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Arrays;

public class Main {
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static int[] dx = { -1, 1, 0, 0 };
  private static int[] dy = { 0, 0, -1, 1 };
  private static String[][] map;
  private static int sizeCnt = 0, N;

  public static void main(String[] args) throws Exception {
    N = Integer.parseInt(br.readLine());
    map = new String[N + 1][N + 1];
    Arrays.fill(map[0], "0");
    ArrayList<Integer> size = new ArrayList<>();

    for (int i = 1; i <= N; i++) {
      String line = "0" + br.readLine();
      String[] inputMapSplit = line.split("");
      map[i] = inputMapSplit;
    }

    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        if (map[i][j].equals("1")) {
          dfs(i, j);
          size.add(sizeCnt);
          sizeCnt = 0;
        }
      }
    }

    size.sort(Comparator.naturalOrder());
    StringBuilder sb = new StringBuilder(size.size() + "\n");
    for (int i = 0; i < size.size(); i++) {
      sb.append(size.get(i) + "\n");
    }

    System.out.println(sb);

  }

  private static void dfs(int y, int x) {
    map[y][x] = "0";
    sizeCnt++;

    for (int i = 0; i < dx.length; i++) {
      int tempY = y + dy[i];
      int tempX = x + dx[i];

      // 1부터 시작하니까 0은 그냥 확인안함.
      if (tempX < map.length && tempY < map.length && map[tempY][tempX].equals("1")) {
        dfs(tempY, tempX);
      }
    }
  }
}
