// 10711 모래성 - BFS

// 쌓인 모래성을 기준으로 탐색 시 시간초과, 메모리 초과가 발생하기 때문에 모래가 없는 부분을 기준으로 탐색을 진행

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {

  public static class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");

    int H = Integer.parseInt(input[0]);
    int W = Integer.parseInt(input[1]);
    char[][] map = new char[H][W]; // 모래성
    boolean[][] none = new boolean[H][W]; // 모래가 없는 부분

    Queue<Pair> noSand = new LinkedList<>();
    Queue<Pair> remove = new LinkedList<>();

    int[] dx = { -1, -1, -1, 0, 1, 1, 0, 1 };
    int[] dy = { -1, 0, 1, 1, 1, -1, -1, 0 };

    for (int i = 0; i < H; i++) {
      String str = br.readLine();
      for (int j = 0; j < W; j++) {
        char x = str.charAt(j);
        map[i][j] = x;

        if (x == '.') {
          noSand.add(new Pair(i, j));
          none[i][j] = true;
        }
      }
    }
    // 인접한 좌표가 모래가 있는 경우 count 배열을 사용하여 모래의 양을 기록
    // t는 while 루프를 통해 탐색한 횟수를 나타내는 변수
    int t = 0;
    int[][] count = new int[H][W];

    // while 루프는 noSand 큐가 비어있을 때까지 반복하며, 각 반복마다 s에 noSand 큐의 크기를 저장
    while (noSand.size() != 0) {
      int s = noSand.size();

      for (int i = 0; i < s; i++) {
        Pair temp = noSand.poll();

        // 기록된 모래의 양이 해당 좌표의 모래 수(map[nx][ny] - '0')와 같거나 크다면,
        // none 배열에 해당 좌표를 표시하고 remove 큐에 추가
        for (int j = 0; j < 8; j++) {
          int nx = temp.x + dx[j];
          int ny = temp.y + dy[j];

          if (nx < 0 || nx >= H || ny < 0 || ny >= W || none[nx][ny])
            continue;

          if (map[nx][ny] != '.') {
            count[nx][ny]++;

            if (count[nx][ny] >= map[nx][ny] - '0') {
              none[nx][ny] = true;
              remove.add(new Pair(nx, ny));
            }
          }
        }
      }
      // remove 큐에 있는 좌표들을 noSand 큐에 다시 추가하고, 이 과정을 반복합니다.
      // 모든 탐색이 완료되면 결과로 t - 1 값을 출력합니다.
      while (!remove.isEmpty()) {
        Pair rm = remove.poll();
        noSand.add(new Pair(rm.x, rm.y));
      }
      t++;
    }
    System.out.println(t - 1);
  }
}
