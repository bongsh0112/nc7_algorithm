import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    int n = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      char find = st.nextToken().charAt(0);
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());

      int tmp = 0;
      for (int j = from; j <= to; j++) {
        if (s.charAt(j) == find) {
          tmp++;
        }
      }
      sb.append(tmp + "\n");
    }
    System.out.println(sb);
  }
}
