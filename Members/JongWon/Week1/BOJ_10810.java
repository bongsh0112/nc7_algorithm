package Members.JongWon.Week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 
 */
public class BOJ_10810 {
  public static int N, M;

  public static void main(String[] args) throws Exception {

    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      String[] lineTempAry = br.readLine().split(" ");
      N = Integer.parseInt(lineTempAry[0]);
      M = Integer.parseInt(lineTempAry[1]);
      if (validNM(N) || validNM(M)) {
        return;
      }

      // 마구니가 끼었느니라
      int[] maguni = new int[N];

      for (int loop = 0; loop < M; loop++) {
        lineTempAry = br.readLine().split(" ");
        int i = Integer.parseInt(lineTempAry[0]);
        int j = Integer.parseInt(lineTempAry[1]);
        int k = Integer.parseInt(lineTempAry[2]);

        if (validIJK(i, j, k)) {
          return;
        }
        for (int stNum = i - 1; stNum < j; stNum++) {
          maguni[stNum] = k;
        }
      }

      StringBuffer sb = new StringBuffer();
      for (int i = 0; i < N; i++) {
        sb.append(maguni[i] + " ");
      }
      System.out.println(sb.toString());
    }

  }

  private static boolean validNM(int num) {
    return num < 1 || num > 100;
  }

  private static boolean validIJK(int i, int j, int k) {
    return i < 1 || i > j || j < i || j > N || k < 1 || k > N;
  }
}
