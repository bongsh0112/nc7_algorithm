import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int X = Integer.parseInt(st.nextToken());

    int[] ary = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      ary[i] = Integer.parseInt(st.nextToken());
    }

    int sum = Arrays.stream(ary, 0, X).sum();
    int max = sum;
    int count = 1;
    for (int i = X; i < N; i++) {
      sum += ary[i];
      sum -= ary[i - X];
      if (sum > max) {
        count = 1;
        max = sum;
      } else if (sum == max) {
        count++;
      }
    }
    System.out.println(max == 0 ? "SAD" : max + "\n" + count);
  }
}
