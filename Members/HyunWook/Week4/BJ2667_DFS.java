// 2667 단지번호붙이기 - DFS

import java.util.ArrayList;
import java.util.Collections;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
  static int N, count;
  static int[][] map;
  static int[] dx = { -1, 1, 0, 0 };
  static int[] dy = { 0, 0, -1, 1 };

  // 어진 좌표 (x, y)를 시작으로 인접한 영역을 재귀적으로 탐색하며,
  // 탐색한 영역을 0으로 바꾸고 단지 내 집의 개수(count)를 증가
  public static void dfs(int x, int y) {
    map[x][y] = 0;
    count += 1;

    // 이후 4방향(상, 하, 좌, 우)으로 이동하면서 인접한 집이 있는지 확인
    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      // 만약 인접한 집이 있고 해당 좌표가 유효한 범위 내에 있다면, 재귀적으로 dfs 함수를 호출
      if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == 1)
        dfs(nx, ny);
    }
  }

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 첫 번째 줄에서는 N을 입력받습니다.
    N = Integer.parseInt(br.readLine());
    // N개의 줄에서는 지도의 정보를 입력받아 map 배열에 저장
    map = new int[N][N];

    for (int i = 0; i < N; i++) {
      String str = br.readLine();
      for (int j = 0; j < N; j++) {
        map[i][j] = str.charAt(j) - '0';
      }
    }

    // ArrayList인 arr은 단지 내 집의 개수를 저장하기 위한 리스트
    ArrayList<Integer> arr = new ArrayList<>();
    // result 변수는 단지의 개수를 저장
    int result = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        count = 0;
        // 만약 현재 좌표에 집이 있고 아직 방문하지 않은 경우, dfs 함수를 호출하여 단지 내 집의 개수(count)를 계산하고,
        // arr 리스트에 추가합니다. 그리고 result를 1 증가시킵니다.
        if (map[i][j] == 1) {
          dfs(i, j);
          arr.add(count);
          result++;
        }
      }
    }

    // 모든 단지를 탐색한 후, arr 리스트를 오름차순으로 정렬
    Collections.sort(arr);
    // result를 출력하고, arr 리스트에 저장된 단지 내 집의 개수를 한 줄에 하나씩 출력
    System.out.println(result);
    for (int i : arr) {
      System.out.println(i);
    }
  }
}

// ## java.util.Collections
// 이 클래스는 컬렉션 데이터를 조작하고 정렬하는 데 사용됩니다. 주요 기능으로는 정렬, 검색, 변환 등이 있습니다.

// Collections 클래스의 주요 메서드와 기능 :

// sort(): 컬렉션을 정렬합니다. 기본적으로 오름차순으로 정렬하며, 정렬 기준은 컬렉션의 요소의 자연 순서입니다.
// 정렬을 위해 컬렉션 내 요소들은 Comparable 인터페이스를 구현해야 합니다.

// reverse(): 컬렉션의 요소들을 역순으로 정렬합니다.

// shuffle(): 컬렉션의 요소들을 임의의 순서로 섞습니다.

// binarySearch(): 이진 검색 알고리즘을 사용하여 특정 요소를 검색합니다. 이진 검색을 위해 컬렉션 내 요소들은 정렬되어 있어야
// 합니다.

// max(), min(): 컬렉션 내 가장 큰 값 또는 가장 작은 값 요소를 반환합니다.

// frequency(): 컬렉션 내에서 특정 요소의 출현 빈도를 반환합니다.

// copy(): 하나의 컬렉션에서 다른 컬렉션으로 요소들을 복사합니다.

// addAll(): 여러 개의 요소를 한 번에 컬렉션에 추가합니다.

// 위의 메서드 외에도 다양한 유틸리티 메서드가 있으며, 이를 활용하여 컬렉션 데이터를 다양한 방식으로 조작할 수 있습니다.
// Collections 클래스는 자바에서 자주 사용되는 유용한 기능을 제공하므로, 컬렉션 데이터를 다룰 때 유용하게 활용할 수 있습니다.