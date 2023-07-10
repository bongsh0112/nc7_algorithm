import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws Exception {
    int N = Integer.parseInt(br.readLine());
    int answer = 0;
    while (N >= 0) {
      if (N % 5 == 0) {
        System.out.println((N / 5 + answer));
        return;
      }
      N -= 3;
      answer++;
    }
    System.out.println("-1");
  }
}
