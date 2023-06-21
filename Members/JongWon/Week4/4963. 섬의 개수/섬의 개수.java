import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  // 왼쪽위, 위, 오른쪽위, 왼쪽, 오른쪽, 왼쪽아래, 아래, 오른쪽 아래
  private static int[] dy = { -1, -1, -1, 0, 0, 1, 1, 1 };
  private static int[] dx = { -1, 0, 1, -1, 1, -1, 0, 1 };

  private static ArrayList<int[][]> mapList = new ArrayList<>();
  private static List<Integer> answer = new ArrayList<>();

  // 섬의 갯수
  public static void main(String[] args) throws Exception {
    while (true) {
      String[] wh = br.readLine().split(" ");

      // While문 탈출!
      if (wh.length == 2 && (wh[0].equals("0") && wh[1].equals("0"))) {
        break;
      }
      int h = Integer.parseInt(wh[1]); // 높이
      int w = Integer.parseInt(wh[0]); // 너비
      int[][] map = new int[h + 5][w + 5]; // 널널하게~

      for (int i = 1; i <= h; i++) { // 높이
        String[] lineStrings = br.readLine().split(" ");
        for (int j = 1; j <= w; j++) {
          map[i][j] = Integer.parseInt(lineStrings[j - 1]);
        }
      }
      mapList.add(map);
    }

    for (int[][] map : mapList) {
      int count = 0;
      for (int i = 1; i <= map.length - 5; i++) {
        for (int j = 1; j <= map[i].length - 5; j++) {
          if (map[i][j] == 1) {
            count++;
            dfs(map, i, j);
          }
        }
      }
      answer.add(count);
    }

    for(int ans:answer){
      System.out.println(ans);
    }
  }

  private static void dfs(int[][] map, int y, int x) {
    map[y][x] = 0;

    for (int i = 0; i < dy.length; i++) {
      int tempY = y + dy[i];
      int tempX = x + dx[i];
      if (map[tempY][tempX] == 1)
        dfs(map, tempY, tempX);
    }
  }
}
