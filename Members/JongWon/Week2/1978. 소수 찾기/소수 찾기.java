import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      // 선언

      int N = Integer.parseInt(br.readLine());
      String[] numbers = br.readLine().split(" ");
      int cnt = 0;
      // 100 * 1000
      for (int i = 0; i < N; i++) {
        boolean isPrimeNum = true;
        int num = Integer.parseInt(numbers[i]);
        if (num <= 2 || (num != 2 && num % 2 == 0))
          isPrimeNum = num == 2 ? true : false;
        else
          for (int j = 3; j < num; j++)
            if (num % j == 0)
              isPrimeNum = false;

        if (isPrimeNum)
          cnt++;
      }

      System.out.println(cnt);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
