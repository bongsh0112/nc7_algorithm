import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws Exception {
    int N = Integer.parseInt(br.readLine());
    Integer[][] nums = new Integer[2][N];

    for (int i = 0; i < 2; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        nums[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    Arrays.sort(nums[0], Comparator.reverseOrder());
    Arrays.sort(nums[1]);
    int sum = 0;
    for (int i = 0; i < N; i++) {
      sum += nums[0][i] * nums[1][i];
    }
    System.out.println(sum);
  }
}