import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  private static int[] dist;
  private static List<List<Integer>> familyMap = new ArrayList<>();

  public static void main(String[] args) throws Exception {
    int N = Integer.parseInt(br.readLine());
    String[] stEd = br.readLine().split(" ");

    int st = Integer.parseInt(stEd[0]);
    int ed = Integer.parseInt(stEd[1]);

    int M = Integer.parseInt(br.readLine());

    dist = new int[N + 5];
    Arrays.fill(dist, -1);
    for (int i = 0; i <= N; i++) {
      familyMap.add(new ArrayList<Integer>());
    }

    for (int i = 0; i < M; i++) {
      String[] fromTo = br.readLine().split(" ");
      int from = Integer.parseInt(fromTo[0]);
      int to = Integer.parseInt(fromTo[1]);

      familyMap.get(from).add(to);
      familyMap.get(to).add(from);
    }

    Queue<Integer> q = new LinkedList<>();
    q.add(st);
    dist[st] = 0;
    while (!q.isEmpty()) {
      Integer tempSt = q.poll();
      List<Integer> tempList = familyMap.get(tempSt);

      for (int nodeNum : tempList) {
        if (dist[nodeNum] != -1) {
          continue;
        }
        q.add(nodeNum);
        dist[nodeNum] = dist[tempSt] + 1;
      }
    }
    System.out.println(dist[ed]);
  }
}
