import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

  static int N;
  static int M;
  static boolean visited[];
  static int[] arr;
  static int cnt;
  static StringBuilder stringBuilder = new StringBuilder();
  
  
  public static void main(String[] args) throws IOException {
    
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    
    int N = Integer.parseInt(bufferedReader.readLine());
    String[] str = bufferedReader.readLine().split(" ");
    
    int[] arr = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      arr[i] = Integer.parseInt(str[i - 1]);
    }
    
    int[] dp = new int[N + 1];
    dp[1] = arr[1];
    
    for (int i = 2; i <= N; i++) {
      dp[i] = arr[i]; // i의 값을 기준점으로 둔다
      for (int j = 1; j < i; j++) { // i 전까지 나오는 값들을 비교하여 증가수열이라면 더해준다.
        if (arr[i] > arr[j]) {
          dp[i] = Math.max(dp[j] + arr[i], dp[i]);
//          dp[i] = dp[j] + arr[i]; // 입력에 음수는 없으므로 더하면 무조건 더 클 것임. 따라서 Math.max는 필요없음
        }
      }
    }
    
    int max = Integer.MIN_VALUE;
    for (int i = 1; i <= N; i++) {
      max = Math.max(dp[i], max);
    }
    
    System.out.println(max);
    
  }
  
}