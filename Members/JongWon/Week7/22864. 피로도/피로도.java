import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    int A = Integer.parseInt(st.nextToken()); // 쌓이는 피로도
    int B = Integer.parseInt(st.nextToken()); // 할수 있는 일의 양
    int C = Integer.parseInt(st.nextToken()); // 한시간 휴식시 내려가는 피로도
    int M = Integer.parseInt(st.nextToken()); // Max 피로도

    int workValue = 0;
    int pirodo = 0;

    // 시간
    for (int i = 0; i < 24; i++) {
      if (A + pirodo > M) {
        pirodo = pirodo - C < 0 ? 0 : pirodo - C;
      } else {
        pirodo += A;
        workValue += B;
      }
    }
    System.out.println(workValue);
  }
}
