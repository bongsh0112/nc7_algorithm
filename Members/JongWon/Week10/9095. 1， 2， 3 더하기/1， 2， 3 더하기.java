import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws Exception {
    int T = Integer.parseInt(br.readLine());
    int N = 12; // 11까지니까..
    int[] ary = new int[N];
    ary[1] = 1;
    ary[2] = 2;
    ary[3] = 4;
    for (int i = 4; i < N; i++)
      ary[i] = ary[i - 1] + ary[i - 2] + ary[i - 3];
    for (int i = 0; i < T; i++)
      System.out.println(ary[Integer.parseInt(br.readLine())]);
  }
}
