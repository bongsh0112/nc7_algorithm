import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  
  public static void main(String[] args) throws IOException {
    
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder stringBuilder = new StringBuilder();
    
    int N = Integer.parseInt(bufferedReader.readLine());
    int[][] tree = new int[N + 1][N + 1];
    for (int i = 0; i < N - 1; i++) {
      String[] str = bufferedReader.readLine().split(" ");
      int a = Integer.parseInt(str[0]);
      int b = Integer.parseInt(str[1]);
      tree[a][b] = 1;
      tree[b][a] = 1;
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
  
  static int getConnLines(int[][] arr, int k) {
    int row = arr.length;
    int col = arr[0].length;
    int count = 0;
    
    for (int i = 1; i < col; i++) { // N+1 arr이므로 1부터 시작. row나 col 중 하나만 가지고 개수 세도 무방함
      if (arr[k][i] == 1) { // 한 노드에 간선이 얼마나 연결되었는지 count를 늘려가며 세기
        count++;
      }
    }
    
    return count;
  }
  
}