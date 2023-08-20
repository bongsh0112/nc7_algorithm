import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {
  
  public static void main(String[] args) throws IOException {
    
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder stringBuilder = new StringBuilder();
    
    int N = Integer.parseInt(bufferedReader.readLine());
    List<Integer>[] tree = new ArrayList[N + 1];
    for (int i = 1; i <= N; i++) {
      tree[i] = new ArrayList<>();
    }
    for (int i = 0; i < N - 1; i++) {
      String[] str = bufferedReader.readLine().split(" ");
      int a = Integer.parseInt(str[0]);
      int b = Integer.parseInt(str[1]);
      tree[a].add(b);
      tree[b].add(a);
      /**
       * 배열과 비슷한 효과가 나지만 도표같이 볼 수는 없을듯
       */
    }
    
    int q = Integer.parseInt(bufferedReader.readLine());
    /**
     * 간선을 끊으면 무조건 그래프가 나뉘게 된다.
     * 맨 끝 노드(리프노드 - 간선이 한개 연결된)를 없애면 그래프가 나뉘지 않지만, 간선이 2개 연결된 노드를 없애게 되면 그래프가 나뉜다.
     */
    for (int i = 0; i < q; i++) {
      String[] str = bufferedReader.readLine().split(" ");
      int t = Integer.parseInt(str[0]);
      int k = Integer.parseInt(str[1]);
      if (t == 1) {
        int count = getConnLines(tree, k);
        if (count == 1) stringBuilder.append("no\n");
        else stringBuilder.append("yes\n");
      } else {
        stringBuilder.append("yes\n");
      }
    }
    
    System.out.println(stringBuilder.toString());
    
  }
  
  static int getConnLines(List<Integer>[] tree, int k) {
    return tree[k].size(); // tree의 각 줄에 있는 원소의 개수 = 간선의 개수
  }
  
}