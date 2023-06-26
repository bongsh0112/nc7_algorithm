package Members.DongYoung.Week4;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;

public class BOJ_2606 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int N = Integer.parseInt(scanner.nextLine());
    int M = Integer.parseInt(scanner.nextLine());

    int[][] adjArr = new int[N + 1][N + 1];
    for (int i = 0; i < M; i++) {
      String inputStr = scanner.nextLine();
      int a1 = Integer.parseInt(inputStr.split(" ")[0]);
      int a2 = Integer.parseInt(inputStr.split(" ")[1]);

      adjArr[a1][a2] = 1;
      adjArr[a2][a1] = 1;
    }
    boolean[] visited = new boolean[N + 1];
    bfs(1, adjArr, visited);
    int answer = 0;
    for (boolean ans : visited) {
      if (ans) {
        answer++;
      }
    }
    System.out.println(answer - 1);

  }

  static void bfs(int num, int[][] adjArr, boolean[] visited) {
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(num);
    visited[num] = true;
    while (!queue.isEmpty()) {
      num = queue.poll();
      for (int i = 1; i <= adjArr.length - 1; i++) {
        if (adjArr[num][i] == 1 && !visited[i]) {
          queue.offer(i);
          visited[i] = true;
        }
      }
    }
  }

}
