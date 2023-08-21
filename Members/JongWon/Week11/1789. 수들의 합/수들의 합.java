
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws Exception {
    long S = Long.valueOf(br.readLine());
    long left = 1, right = S;
    long answer = 0;
    while (left <= right) {
      long mid = (left + right) / 2;
      if (mid * (mid + 1) / 2 > S)
        right = mid - 1;
      else {
        answer = mid;
        left = mid + 1;
      }
    }
    System.out.println(answer);
  }
}
