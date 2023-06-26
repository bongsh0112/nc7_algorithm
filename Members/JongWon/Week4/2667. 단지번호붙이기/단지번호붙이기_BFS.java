import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class Main {
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static int[] dx = { 0, 0, -1, 1 };
  private static int[] dy = { -1, 1, 0, 0, };
  private static String[][] map;
  private static int N;

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
          size.add(bfs(new xy(i, j)));
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

  private static int bfs(xy node) {
    int area = 0;
    LinkedList<xy> queue = new LinkedList<>();
    queue.add(node);
    while (!queue.isEmpty()) {
      xy tempNode = queue.poll();

      if (map[tempNode.y][tempNode.x].equals("0")) {
        continue;
      }
      area++;
      map[tempNode.y][tempNode.x] = "0";

      for (int i = 0; i < dx.length; i++) {
        int tempY = tempNode.y + dy[i];
        int tempX = tempNode.x + dx[i];
        // 1부터 시작하니까 0은 그냥 확인안함.
        if (tempX < map.length && tempY < map.length && map[tempY][tempX].equals("1")) {

          queue.add(new xy(tempY, tempX));
        }
      }
    }
    return area;
  }
}

class xy {
  public int y;
  public int x;

  public xy(int y, int x) {
    this.y = y;
    this.x = x;
  }
}
