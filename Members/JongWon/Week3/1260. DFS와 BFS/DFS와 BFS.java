package Members.JongWon.Week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N, M, V;
    Map<Integer, List<Integer>> fsMap = new HashMap<>();

    // 초기화
    String[] NMV = br.readLine().split(" ");
    N = Integer.parseInt(NMV[0]);
    M = Integer.parseInt(NMV[1]);
    V = Integer.parseInt(NMV[2]);

    for (int i = 0; i <= N; i++) {
      fsMap.put(i, new ArrayList<>());
    }

    for (int i = 0; i < M; i++) {
      String[] line = br.readLine().split(" ");
      int stNum = Integer.parseInt(line[0]);
      int edNum = Integer.parseInt(line[1]);
      fsMap.get(stNum).add(edNum); // Map의 List에 넣는법
      fsMap.get(edNum).add(stNum);
    }
    new dfs(N, V, fsMap);
    new bfs(N, V, fsMap);
  }
}

class dfs {
  private int[] visited;
  private Map<Integer, List<Integer>> fsMap = new HashMap<>();
  private int N;
  private StringBuffer sb = new StringBuffer();

  public dfs(int N, int V, Map<Integer, List<Integer>> map) {
    this.fsMap = map;
    this.N = N;
    visited = new int[N + 1];
    run(V);
    System.out.println(sb);
  }

  private void run(int V) {
    visited[V]++;
    sb.append(V + " ");

    List<Integer> nodeList = fsMap.get(V);
    nodeList.sort(Comparator.naturalOrder());

    for (int i = 0; i < nodeList.size(); i++) {
      int nodeNum = nodeList.get(i);
      if (visited[nodeNum] == 0) {
        run(nodeNum);
      }
    }
  }

}

class bfs {
  private int[] visited;
  private Map<Integer, List<Integer>> fsMap = new HashMap<>();
  private LinkedList<Integer> list = new LinkedList<>();
  private int N;
  private StringBuffer sb = new StringBuffer();

  public bfs(int N, int V, Map<Integer, List<Integer>> map) {
    this.fsMap = map;
    this.N = N;
    visited = new int[N + 1];
    run(V);
    System.out.println(sb);
  }

  private void run(int V) {
    list.add(V);
    int num;
    while (list.size() > 0) {
      num = list.poll();
      visited[num]++;
      if (visited[num] == 1) {
        sb.append(num + " ");
      }

      List<Integer> tempList = fsMap.get(num);
      tempList.sort(Comparator.naturalOrder());
      for (int i = 0; i < tempList.size(); i++) {
        if (visited[tempList.get(i)] == 0) {
          list.add(tempList.get(i));
        }
      }
    }

  }
}