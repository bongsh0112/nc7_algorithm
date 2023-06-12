import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      // 선언
      StringBuffer sb = new StringBuffer();
      String[] line = null;

      while (true) {
        line = br.readLine().split(" ");
        int A = Integer.parseInt(line[0]);
        int B = Integer.parseInt(line[1]);

        if (A == 0 && B == 0) {
          break;
        }

        if (A > B) // A/B의 나머지가 0이면서 B/A의 나머지가 B면 배수 ,(즉 A가 더 큰 경우)
          sb.append(A % B == 0 ? "multiple\n" : "neither\n");
        else // A / B의 나머지가 A면서 B/A의 나머지가 0인 경우 (B가 더 크기에 약수)
          sb.append(B % A == 0 ? "factor\n" : "neither\n");
      }
      System.out.println(sb.toString());

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
