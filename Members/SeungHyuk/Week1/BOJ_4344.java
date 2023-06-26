import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4344 {
  public static void main (String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int tc = Integer.parseInt(br.readLine());
    int[] arr;
    int sum, count;

    for (int i = 0; i < tc; i++) {
      sum = 0;
      count = 0;
      // int num = 0;

      st = new StringTokenizer(br.readLine(), " ");
      int num = Integer.parseInt(st.nextToken());

      arr = new int[num]; // 배열 생성
      
      for (int j = 0; j < num; j++) { // 한 줄씩 받는다
        arr[j] = Integer.parseInt(st.nextToken());
        sum += arr[j];
      }
      for (int j = 0; j < num; j++) {
        if ((double)sum /num < arr[j]) {
          count++;
        }
      }
      System.out.printf("%.3f%%\n", (double)count / num * 100);
    }
  }
}
