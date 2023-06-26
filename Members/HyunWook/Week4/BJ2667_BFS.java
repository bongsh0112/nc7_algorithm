// 2667 단지번호붙이기 - BFS

import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Collections;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
  static int N, count; // N은 지도의 크기를 나타내는 변수
  // N x N 크기의 2차원 배열로, 각 지점의 상태를 저장합니다. dx와 dy 배열은 상하좌우 이동에 대한 정보를 담고 있습니다.
  static int[][] map; //
  static int[] dx = { -1, 1, 0, 0 };
  static int[] dy = { 0, 0, -1, 1 };

  // BFS 알고리즘을 사용하여 단지를 탐색하고 집의 수를 세는 역할
  public static void bfs(int x, int y) {
    // 큐에서 위치를 꺼내고, 집의 수를 1 증가시킵니다
    Queue<int[]> que = new LinkedList<>();
    // 상하좌우로 이웃한 위치를 확인하고, 지도 내에 있고 상태가 1인 경우에는 해당 위치의 상태를 0으로 변경하고 큐에 추가
    que.add(new int[] { x, y });
    map[x][y] = 0;

    while (!que.isEmpty()) {
      count += 1;
      int now[] = que.poll();
      for (int i = 0; i < 4; i++) {
        int nx = now[0] + dx[i];
        int ny = now[1] + dy[i];

        if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == 1) {
          map[nx][ny] = 0;
          que.offer(new int[] { nx, ny });
        }
      }
    }
  }

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // N을 입력받아 지도의 크기를 설정
    N = Integer.parseInt(br.readLine());
    // map 배열을 입력받아 지도의 상태를 저장
    map = new int[N][N];

    for (int i = 0; i < N; i++) {
      String str = br.readLine();
      for (int j = 0; j < N; j++) {
        map[i][j] = str.charAt(j) - '0';
      }
    }

    // arr 리스트는 각 단지에 속하는 집의 수를 저장할 리스트입니다. result 변수는 단지의 수를 저장합니다.
    ArrayList<Integer> arr = new ArrayList<>();
    int result = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        count = 0;
        // map 배열을 순회하면서 탐색을 진행
        // 현재 위치가 1인 경우, 해당 위치를 시작으로 bfs 함수를 호출하여 단지를 탐색하고
        // 집의 수를 세고 arr 리스트에 추가합니다. 이후 result를 1 증가
        if (map[i][j] == 1) {
          bfs(i, j);
          arr.add(count);
          result++;
        }
      }
    }

    // result는 단지의 수를, arr 리스트는 각 단지에 속하는 집의 수를 출력
    Collections.sort(arr);
    System.out.println(result);
    for (int i : arr) {
      System.out.println(i);
    }
  }
}

// https://141227.tistory.com/236 : 참조(정리잘됌)
