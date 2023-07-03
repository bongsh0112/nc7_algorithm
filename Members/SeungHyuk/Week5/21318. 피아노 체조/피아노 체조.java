import java.io.*;
import java.util.*;
// 피아노 체조
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N + 1];
    int[] sumArr = new int[N + 1];

    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      if (arr[i - 1] > arr[i]) {
        sumArr[i] += sumArr[i - 1] + 1;
      } else {
        sumArr[i] = sumArr[i - 1];
      }
    }
    
    int M = Integer.parseInt(br.readLine());
    int start, end;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      start = Integer.parseInt(st.nextToken());
      end = Integer.parseInt(st.nextToken());
      sb.append(sumArr[end]-sumArr[start] + "\n");
    }
    
    System.out.println(sb.toString());
  }
}