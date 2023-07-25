package Members.JongWon.Week8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws Exception {
    PriorityQueue<Integer[]> q = new PriorityQueue<>((o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);
    int N = Integer.parseInt(br.readLine());
    for (int i = 0; i < N; i++) {
      String[] time = br.readLine().split(" ");
      q.offer(new Integer[] { Integer.parseInt(time[0]), Integer.parseInt(time[1]) });
    }

    int lastTime = Integer.MIN_VALUE;
    int answer = 0;
    while (!q.isEmpty()) {
      Integer[] t = q.poll();
      if (t[0] >= lastTime) {
        lastTime = t[1];
        answer++;
      }
    }
    System.out.println(answer);
  }
}
