import java.io.*;
// 진법 변환 2
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    String[] str = br.readLine().split(" ");
    int num = Integer.parseInt(str[0]);
    int n = Integer.parseInt(str[1]);

    while (num > 0) {
      if ((num % n) >= 10) {
        sb.append((char) (num % n + 55)); // (char) (num % n - 10) + 'A'
        num /= n;
      } else {
        sb.append(num % n);
        num /= n;
      }
    }
    System.out.println(sb.reverse().toString());
  }
}