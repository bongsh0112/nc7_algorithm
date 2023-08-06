import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws Exception {
    int[] num = new int[11];
    for (int i = 1; i < 11; i++) {
      num[i] = num[i - 1] + Integer.parseInt(br.readLine());
    }
    int idx = 1;
    for (int i = 2; i < 11; i++) {
      int a = (int) Math.abs(100 - num[i]);
      int b = (int) Math.abs(100 - num[idx]);
      if (a == b)
        idx = num[i] > num[idx] ? i : idx;
      else if (a < b)
        idx = i;
    }
    System.out.println(num[idx]);
  }
}
