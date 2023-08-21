import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws Exception {
    int N = Integer.parseInt(br.readLine());
    int[] node = new int[N + 1];
    for (int i = 0; i < N - 1; i++) {
      int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      node[num[0]]++;
      node[num[1]]++;
    }
    StringBuilder sb = new StringBuilder();
    int q = Integer.parseInt(br.readLine());
    for (int i = 0; i < q; i++) {
      int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      if (num[0] == 1)
        sb.append(node[num[1]] == 1 ? "no" : "yes");
      else
        sb.append("yes");
      sb.append("\n");
    }
    System.out.println(sb);
  }

}
