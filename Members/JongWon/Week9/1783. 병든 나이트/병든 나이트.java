import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws Exception {
    String[] NM = br.readLine().split(" ");
    int N = Integer.parseInt(NM[0]);
    int M = Integer.parseInt(NM[1]);
    if (N == 1) {
      System.out.println(1);
      return;
    }
    if (N == 2) {
      M++;
      System.out.println(M > 8 ? 4 : M / 2);
      return;
    }
    if (M < 5) { // 1,2,3,4
      System.out.println(M);
      return;
    }
    if (M <= 6) { // 5,6
      System.out.println(4);
      return;
    }
    // 가로길이 7이상
    int cnt = 4;
    M -= 6;
    cnt += M;
    System.out.println(cnt);
  }
}
