import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      String[] line = br.readLine().split(" ");
      int N = Integer.parseInt(line[0]);
      int B = Integer.parseInt(line[1]);

      StringBuffer sb = new StringBuffer();
      while (true) {
        if (N < B) {
          // 종료
          if (B >= 11 && N >= 10) {
            sb.append((char) ('A' + (N - 10)));
          } else {
            sb.append(N);
          }
          break;
        } else {
          int mod = N % B;
          if (B >= 11 && mod >= 10) {
            sb.append((char) ('A' + (mod - 10)));
          } else {
            sb.append(mod);
          }
          N = N / B;
        }
      }

      System.out.println(sb.reverse().toString());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
