import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//16139
public class Main {
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws Exception {
    StringTokenizer st;
    String str = br.readLine();
    int[][] prefixAry = new int[26][str.length() + 1];

    for (int i = 1; i <= str.length(); i++) {
      char c = str.charAt(i - 1); // idx를 1부터 시작했기 때문
      for (int j = 0; j <= 25; j++)
        if (j == c - 'a')
          prefixAry[j][i] = prefixAry[j][i - 1] + 1;
        else
          prefixAry[j][i] = prefixAry[j][i - 1];
    }
    int q = Integer.parseInt(br.readLine());
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < q; i++) {
      st = new StringTokenizer(br.readLine());
      char c = st.nextToken().charAt(0);
      int stNum = Integer.parseInt(st.nextToken());
      int endNum = Integer.parseInt(st.nextToken()) + 1;
      sb.append(prefixAry[c - 'a'][endNum] - prefixAry[c - 'a'][stNum] + "\n");
    }
    System.out.println(sb);
  }
}
