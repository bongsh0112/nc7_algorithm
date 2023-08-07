import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws Exception {
    String[] NS = br.readLine().split(" ");
    int N = Integer.parseInt(NS[0]);
    int S = Integer.parseInt(NS[1]);

    int[] nums = new int[N + 1];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++)
      nums[i] = Integer.parseInt(st.nextToken());

    int min = Integer.MAX_VALUE;
    int start = 0, end = 0, total = 0;

    // 투포인터가 모두 배열안에서만 활동하도록
    while (start <= end && end <= N) {
      // S모다 큰수면서 min(길이)가 현재 min보다 작은 경우에 변경함
      min = total >= S && min > end - start ? end - start : min;
      total = total < S ? total + nums[end++] : total - nums[start++];
    }
    System.out.println(min == Integer.MAX_VALUE ? "0" : min);
  }
}
