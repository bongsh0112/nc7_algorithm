import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws Exception {
    int N = Integer.parseInt(br.readLine());
    int[] ary = new int[N + 1];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++)
      ary[i] = Integer.parseInt(st.nextToken());
    Arrays.sort(ary);

    int sum = 0;
    for (int i = 1; i <= N; i++) {
      ary[i] += ary[i - 1];
      sum += ary[i];
    }
    System.out.println(sum);
  }
}
