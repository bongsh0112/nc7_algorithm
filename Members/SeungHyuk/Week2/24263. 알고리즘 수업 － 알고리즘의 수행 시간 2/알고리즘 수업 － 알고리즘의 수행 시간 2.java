import java.io.*;
// 알고리즘 수업 - 알고리즘 수행 시간 1
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(br.readLine());
    sb.append(n + "\n");
    sb.append(1 + "\n");
    System.out.println(sb);
  }
}
