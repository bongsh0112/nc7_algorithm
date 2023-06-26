package Members.DongYoung.Week4;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_2667 {

  // 방향백터 설정
  static int[] dx = { 0, 1, 0, -1 };
  static int[] dy = { -1, 0, 1, 0 };

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int N = Integer.parseInt(scanner.nextLine());
    int[][] adjArr = new int[N + 1][N + 1];
    ArrayList<Integer> countList = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      String inputStr = scanner.nextLine();
      for (int j = 0; j < inputStr.length(); j++) {
        adjArr[i + 1][j + 1] = Integer.parseInt(inputStr.substring(j, j + 1));
      }
    }

    boolean[][] visited = new boolean[N + 1][N + 1];
    int cnt = 0;
    for (int i = 1; i < adjArr.length; i++) {
      for (int j = 1; j < adjArr.length; j++) {
        int visitedCnt = visitedSize(visited);
        bfs(i, j, adjArr, visited);
        if (visitedSize(visited) > visitedCnt) {
          countList.add(visitedSize(visited) - visitedCnt);
          cnt++;
        }
      }
    }
    System.out.println(cnt);
    Collections.sort(countList);
    for (Integer a : countList) {
      System.out.println(a);
    }
    scanner.close();

  }

  static void dfs(int x, int y, int[][] adjArr, boolean[][] visited) {
    for (int i = 0; i < 4; i++) {
      int x1 = x + dx[i];
      int y1 = y + dy[i];
      if (x1 >= 1 && x1 <= adjArr.length - 1 && y1 >= 1 && y1 <= adjArr.length - 1) {
        if (!visited[x1][y1] && adjArr[x1][y1] == 1) {
          dfs(x1, y1, adjArr, visited);
          visited[x1][y1] = true;
        }
      }
    }

  }

  static boolean bfs(int x, int y, int[][] adjArr, boolean[][] visited) {
    if (adjArr[x][y] == 0 || visited[x][y]) {
      return false;
    }
    Queue<int[]> queue = new LinkedList<>();
    int[] arr = { x, y };
    queue.offer(arr);
    visited[x][y] = true;
    while (!queue.isEmpty()) {
      arr = queue.poll();
      x = arr[0];
      y = arr[1];
      for (int i = 0; i < 4; i++) {
        int x1 = x + dx[i];
        int y1 = y + dy[i];
        if (x1 >= 1 && x1 <= adjArr.length - 1 && y1 >= 1 && y1 <= adjArr.length - 1) {
          if (!visited[x1][y1] && adjArr[x1][y1] == 1) {
            queue.offer(new int[] { x1, y1 });
            visited[x1][y1] = true;
          }
        }
      }
    }
    return true;
  }

  static int visitedSize(boolean[][] visited) {
    int ans = 0;
    for (int i = 0; i < visited.length; i++) {
      for (int j = 0; j < visited.length; j++) {
        if (visited[i][j]) {
          ans++;
        }
      }
    }
    return ans;
  }
}
