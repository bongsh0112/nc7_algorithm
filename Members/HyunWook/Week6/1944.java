// 1944 복제로봇 - BFS

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {

  static class Robot implements Comparable<Robot> {
    int row, col;
    int dis;

    public Robot(int row, int col, int dis) {
      this.row = row;
      this.col = col;
      this.dis = dis;
    }

    @Override
    public int compareTo(Robot o) {
      return this.dis - o.dis;
    }
  }

  static int dx[] = { 1, 0, -1, 0 };
  static int dy[] = { 0, -1, 0, 1 };

  static int N, M, res, cnt;
  static int SROW, SCOL;

  static int map[][];
  static boolean visit[][];

  static Queue<int[]> q = new LinkedList<>();
  static PriorityQueue<Robot> pq = new PriorityQueue<>();

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    M = sc.nextInt();
    visit = new boolean[N][N];
    map = new int[N][N];

    for (int i = 0; i < N; i++)
      Arrays.fill(map[i], Integer.MAX_VALUE);

    for (int i = 0; i < N; i++) {
      String s = sc.next();
      for (int j = 0; j < N; j++) {
        char c = s.charAt(j);
        if (c == '1') {
          map[i][j] = -1;
          continue;
        }

        if (c == 'S') {
          pq.add(new Robot(i, j, 0));
          visit[i][j] = true;
        } else if (c == 'K') {
          // key 자리를 0
          q.add(new int[] { i, j });
          map[i][j] = 0;
        }
      }
    }

    bfs();
    while (!q.isEmpty()) {
      int[] pos = q.poll();
      res += map[pos[0]][pos[1]];
    }

    if (cnt == M)
      System.out.println(res);
    else
      System.out.println(-1);

  }

  private static void bfs() {
    while (!pq.isEmpty()) {

      Robot robot = pq.poll();
      // 현재 자리가 키라면 로봇 복제
      if (map[robot.row][robot.col] == 0) {
        map[robot.row][robot.col] = robot.dis;
        cnt++;
        if (cnt == M)
          return;
        // 거리를 초기화한 로봇
        pq.add(new Robot(robot.row, robot.col, 0));
        continue;
      }
      for (int d = 0; d < 4; d++) {
        int nx = robot.row + dx[d];
        int ny = robot.col + dy[d];
        if (!safe(nx, ny) || map[nx][ny] == -1)
          continue;

        // 키라면
        if (map[nx][ny] == 0) {
          visit[nx][ny] = true;
          pq.add(new Robot(nx, ny, robot.dis + 1));
        }
        // 더 빠른 경로로 이동할 수 있다면
        else if (robot.dis + 1 < map[nx][ny] && !visit[nx][ny]) {
          // 맵 갱신
          map[nx][ny] = robot.dis + 1;
          pq.add(new Robot(nx, ny, robot.dis + 1));
        }
      }
    }
  }

  private static boolean safe(int nx, int ny) {
    if (nx >= 0 && ny >= 0 && nx < N && ny < N)
      return true;
    return false;
  }

}

// https://johoonday.tistory.com/235 : 참조(정리잘됌)
