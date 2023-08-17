import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  
  static int[] liquor;
  static int[] sum;
  
  public static void main(String[] args) throws IOException {
    
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder stringBuilder = new StringBuilder();
    
    int n = Integer.parseInt(bufferedReader.readLine());
    
    liquor = new int[n + 1];
    sum = new int[n + 1];
    
    for (int i = 1; i <= n; i++) {
      liquor[i] = Integer.parseInt(bufferedReader.readLine());
    }
    
    sum[1] = liquor[1];
    if (n > 1) {
      sum[2] = liquor[1] + liquor[2];
    }
    
    for (int i = 3; i <= n; i++) {
      sum[i] = Math.max(sum[i - 1], Math.max(sum[i - 2] + liquor[i], sum[i - 3] + liquor[i - 1] + liquor[i]));
      /**
       * i - 1 : 이전께 3잔 연속
       * i - 2 : 이전전거 먹기 + 그다음꺼 안먹고 마지막꺼 먹기
       * i - 3 : 이전전전거 먹기 + 그 다음꺼 안먹고 그 다음꺼 + 그 다음꺼 먹기
       */
    }
    
    System.out.println(sum[n]);
    
  }
  
}