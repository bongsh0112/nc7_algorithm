import java.io.*;
// 배수와 약수
public class Main {
  public static void main (String[] args) throws IOException {
    BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int x, y;
    while (true) {
      String[] str = br.readLine().split(" ");
      x = Integer.parseInt(str[0]);
      y = Integer.parseInt(str[1]);
      if (x == 0 && y == 0) break;
      if (x < y && y % x == 0) {
        sb.append("factor\n");
      } else if (x > y && x % y == 0) {
        sb.append("multiple\n");
      } else {
        sb.append("neither\n");
      }
    }
    System.out.println(sb);
  }
}
