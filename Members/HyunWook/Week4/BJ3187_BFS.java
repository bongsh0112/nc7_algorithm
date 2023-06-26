// 3187 양치기 꿍 - BFS

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  // 첫 번째 줄에서는 양과 늑대가 있는 맵의 크기인 R과 C를 입력받습니다.
  static int R, C;
  static char arr[][];
  static boolean visit[][];
  static int moveX[] = { 0, 1, 0, -1 };
  static int moveY[] = { -1, 0, 1, 0 };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    arr = new char[R][C];
    visit = new boolean[R][C];
    int sheep = 0;
    int wolf = 0;
    for (int r = 0; r < R; r++) {
      String str = br.readLine();
      for (int c = 0; c < C; c++) {
        // 맵의 상태를 2차원 배열 arr에 저장합
        arr[r][c] = str.charAt(c);
      }
    }
    // R개의 줄에 걸쳐 맵의 상태가 주어집니다. 각 줄에는 C개의 문자가 주어지며, '#'은 울타리, 'k'는 양, 'v'는 늑대를 나타냅니다.
    for (int r = 0; r < R; r++) {
      for (int c = 0; c < C; c++) {
        // 만약 해당 위치가 울타리가 아니고(!visit[r][c]) 방문하지 않았다면,
        // bfs 함수를 호출하여 해당 위치에서의 양과 늑대의 수를 구합니다.
        if (arr[r][c] != '#' && !visit[r][c]) {
          // 반환된 Point 객체의 x값은 늑대의 수, y값은 양의 수를 나타냅니다.
          Point po = bfs(r, c);
          // 양과 늑대의 수를 각각 증가시킵니다.
          wolf += po.x;
          sheep += po.y;
        }
      }
    }
    System.out.println(sheep + " " + wolf);
  }

  private static Point bfs(int row, int col) {
    // TODO Auto-generated method stub
    Queue<Point> queue = new LinkedList<Point>();
    // 시작 위치인 (row, col)을 큐에 넣고 방문했음을 표시하기 위해 visit 배열의 해당 위치를 true로 설정합니다.
    visit[row][col] = true;
    queue.add(new Point(col, row));
    // 초기 양과 늑대의 수를 0으로 초기화합니다.
    int sheep = 0;
    int wolf = 0;
    // 큐가 비어있을 때까지 반복하며, 큐에서 좌표를 하나씩 꺼냅니다.
    while (!queue.isEmpty()) {
      Point po = queue.poll();
      // 꺼낸 좌표의 위치에 있는 문자가 'v'인 경우 늑대 수를 증가시키고, 'k'인 경우 양 수를 증가시킵니다.
      if (arr[po.y][po.x] == 'v')
        wolf++;
      else if (arr[po.y][po.x] == 'k')
        sheep++;

      // 현재 위치의 상하좌우를 탐색하여 이동할 수 있는 위치를 큐에 넣고 방문했음을 표시
      for (int d = 0; d < 4; d++) {
        int newY = po.y + moveY[d];
        int newX = po.x + moveX[d];

        if (0 <= newY && newY < R && 0 <= newX && newX < C && !visit[newY][newX] && arr[newY][newX] != '#') {
          visit[newY][newX] = true;
          queue.add(new Point(newX, newY));
        }
      }
    }
    if (wolf >= sheep) {
      sheep = 0;
    } else {
      wolf = 0;
    }

    return new Point(wolf, sheep);
  }
}