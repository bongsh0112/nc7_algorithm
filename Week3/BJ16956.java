
// 16956 늑대와 양 - BFS()
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int r, c;  // 목장의 크기
  static char[][] map;  // r x c 크기의 char 타입 2차원 배열로, 목장의 정보를 저장
  static Queue<int[]> q = new LinkedList<>(); // BFS를 위한 큐(queue)
  // 'dx' 와 'dy'는 상하좌우로 이동하기 위한 배열
  static int[] dx = { -1, 1, 0, 0 };
  static int[] dy = { 0, 0, -1, 1 };
  static boolean flag = true; // flag는 양이 늑대에게 잡히는 경우를 나타내는 변수

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());

    // map 배열을 생성하고, 입력을 받아 울타리 지도 정보를 초기화합니다.
    // 입력으로 주어지는 문자열은 행마다 울타리의 상태를 나타내며, 문자열의 각 문자는 각 열의 울타리 상태를 의미
    // 입력받은 문자열 s를 반복문을 사용하여 한 문자씩 읽어서 map[i][j]에 저장합니다. i는 행 인덱스, j는 열 인덱스
    // 만약 해당 위치의 울타리 상태가 'W'인 경우(늑대의 위치), 큐에 해당 위치의 좌표를 추가합니다.
    // 좌표는 new int[] { i, j }를 통해 배열로 생성하여 큐에 추가
    // 큐에는 늑대의 위치가 저장되어 늑대 주변을 탐색하기 위해 활용
    map = new char[r][c]; 
    for (int i = 0; i < r; i++) {
      String s = br.readLine();
      for (int j = 0; j < c; j++) {
        map[i][j] = s.charAt(j);
        if (map[i][j] == 'W') {
          q.add(new int[] { i, j });
        }
      }
    }
    // bfs() 함수를 호출하여 BFS 탐색을 시작합니다. 이 함수에서는 큐(q)에 저장된 늑대의 위치를 기준으로 상하좌우로 인접한
    // 칸을 탐색하며, 양(S)이 있는지 여부를 확인합니다.
    // 만약 양(S)을 발견하면 flag 변수를 false로 설정
    // flag가 true인 경우, 즉 양(S)이 모두 늑대(W)에게 위협되지 않는 경우 "1"을 출력하고, 울타리 지도의 상태를 출력
    // flag가 false인 경우, 즉 양(S) 중 하나 이상이 늑대(W)에게 위협되는 경우입니다. 이 경우에는 "0"을 출력
    bfs();
    if (flag) {
      System.out.println("1");
      for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++) {
          System.out.print(map[i][j]);
        }
        System.out.println();
      }
    } else {
      System.out.println("0");
    }

  }

//  while (!q.isEmpty()): 큐(q)가 비어있지 않은 동안 반복합니다. 큐에는 초기에 늑대의 위치인 좌표(t)가 저장되어 있습니다.
// int[] t = q.poll(): 큐에서 좌표(t)를 하나 꺼냅니다. 이 좌표는 현재 탐색 중인 늑대의 위치입니다.
// int x = t[0]와 int y = t[1]: 좌표(t)에서 x 좌표와 y 좌표를 각각 x와 y 변수에 저장합니다.
// for (int i = 0; i < 4; i++): 상하좌우 4방향에 대해서 반복합니다.
// int nx = x + dx[i]와 int ny = y + dy[i]: 현재 위치에서 상하좌우 방향으로 이동한 좌표(nx, ny)를 계산합니다.
// if (nx >= 0 && nx < r && ny >= 0 && ny < c): 계산된 좌표(nx, ny)가 유효한 범위 내에 있는지 확인합니다.
// 즉, 지도의 범위를 벗어나지 않는지를 검사합니다.
// if (map[nx][ny] == '.'): 계산된 좌표의 위치에 '.'(빈 공간)이 있는 경우를 처리합니다.
// 해당 좌표를 늑대로 울타리를 설치하기 위해 'D'로 변경합니다. ('D'는 늑대가 될 수 있는 울타리를 의미합니다.)
// if (map[nx][ny] == 'S'): 계산된 좌표의 위치에 'S'(양)이 있는 경우를 처리합니다.
// 양이 늑대에게 위협받는 상황이므로 flag 변수를 false로 설정하고, 함수 실행을 종료합니다.
  static void bfs() {
    while (!q.isEmpty()) {
      int[] t = q.poll();
      int x = t[0];
      int y = t[1];
      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
          if (map[nx][ny] == '.') {
            map[nx][ny] = 'D';
          }
          if (map[nx][ny] == 'S') {
            flag = false;
            return;
          }
        }
      }
    }
  }
}

// BFS 와 DFS
// BFS와 DFS는 그래프 탐색 알고리즘 중 가장 기본적인 두 가지 방법입니다.
// 이들은 주어진 그래프에서 노드를 탐색하고 연결된 모든 노드를 방문하는 데 사용됩니다.

// BFS (너비 우선 탐색) - (Breadth-First Search):
// BFS는 그래프 탐색을 수평적으로 진행하는 알고리즘입니다. 즉, 같은 레벨에 있는 모든 노드를 먼저 탐색한 후에 다음 레벨로 넘어갑니다.
// BFS는 큐(Queue) 자료구조를 사용하여 구현됩니다.
// 시작 노드를 큐에 넣고, 큐에서 노드를 하나씩 꺼내면서 그와 연결된 노드를 큐에 추가합니다.
// BFS는 가까운 노드부터 순차적으로 탐색하기 때문에 최단 경로를 찾는 문제에 자주 활용됩니다.

// DFS (깊이 우선 탐색):
// DFS는 그래프 탐색을 깊이 방향으로 진행하는 알고리즘입니다. 즉, 한 경로를 따라 끝까지 탐색한 후에 다음 경로로 넘어갑니다.
// DFS는 스택(Stack) 자료구조를 사용하여 구현됩니다. 시작 노드를 스택에 넣고,
// 스택에서 노드를 하나씩 꺼내면서 그와 연결된 노드를 스택에 추가합니다.
// DFS는 모든 분기를 탐색하고자 할 때 유용하며, 그래프 내에 특정한 경로가 존재하는지 여부를 확인하는 문제에 자주 활용됩니다.
// 요약하면, BFS는 너비 우선으로 그래프를 탐색하며 가까운 노드부터 차례로 방문하고,
// DFS는 깊이 우선으로 그래프를 탐색하며 한 경로를 끝까지 탐색한 후 다른 경로로 넘어갑니다.
// 이러한 특성에 따라 각각의 알고리즘은 다양한 문제에 활용됩니다.
