import java.io.*;
import java.util.*;
// 귀찮아(SIB)
public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n + 1];
    int[] sumArr = new int[n + 1];

    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 1; i <= n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      sumArr[i] = sumArr[i - 1] + arr[i]; // [x1, x1+x2, x1+x2+x3, ...]
    }

    long ret =0;
    for (int i = 1; i < n; i++) {
      ret += arr[i] * (sumArr[n] - sumArr[i]) ; // [x1(x2+x3), x2(x3), ...] 줄어든다
    }
    System.out.println(ret);
  }
}
