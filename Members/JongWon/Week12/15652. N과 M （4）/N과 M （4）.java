import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static int N, M;
  private static boolean[] isUsed = new boolean[10];
  private static int arr[] = new int[10];

  public static void main(String[] args) throws Exception {
    int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    N = input[0];
    M = input[1];
    StringBuilder sb = new StringBuilder();
    tracking(1, 0, sb);
    System.out.println(sb);
  }

  private static void tracking(int at, int num, StringBuilder sb) {
    if (num == M) {
      for (int i = 0; i < M; i++) {
        sb.append(arr[i] + " ");
      }
      sb.append("\n");
      return;
    }

    for (int i = at; i <= N; i++) {
      if (!isUsed[i]) {
        arr[num] = i;
        tracking(i, num + 1, sb);
      }
    }
  }
}
