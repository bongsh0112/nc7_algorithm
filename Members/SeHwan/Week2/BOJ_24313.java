package Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_24313 {

  // f = a1 * n + a0
  // g = n
  // 모든 n >= n0에 대하여 f <= c * g(n)이면 1 리턴 그렇지 않은 n이 하나라도 있으면 0 리턴


  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] A = br.readLine().split(" ");
    int a1 = Integer.parseInt(A[0]);
    int a0 = Integer.parseInt(A[1]);
    int c = Integer.parseInt(br.readLine());
    int nZero = Integer.parseInt(br.readLine());

    if (a1 * nZero+ a0 <= c * nZero && c <= a1) {
      System.out.println(1);
    } else {
      System.out.println(0);
    }

  }

}
