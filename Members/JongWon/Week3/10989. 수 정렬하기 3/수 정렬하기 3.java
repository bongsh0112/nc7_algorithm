import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] cntAry = new int[10000 + 1];

    int N = Integer.parseInt(br.readLine());
    for (int i = 0; i < N; i++) {
      cntAry[Integer.parseInt(br.readLine())]++;
    }
    StringBuffer sb = new StringBuffer();
    for (int i = 1; i < cntAry.length; i++) {
      int cnt = cntAry[i];
      if (cnt != 0)
        for (int j = 0; j < cnt; j++) {
          sb.append(i + "\n");
        }
    }
    System.out.println(sb);
  }
}