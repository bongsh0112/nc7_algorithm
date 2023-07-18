import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  
  public static void main(String[] args) throws IOException {
    
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    
    int n = Integer.parseInt(bufferedReader.readLine());
    int[] arr = new int[n + 1];
    int[] sum = new int[n + 1];
    String[] str = bufferedReader.readLine().split(" ");
    for (int i = 1; i <= n; i++) {
      arr[i] = Integer.parseInt(str[i - 1]);
      sum[i] = sum[i - 1] + arr[i];
    }
    
    long mulSum = 0;
    for (int i = 1; i <= n; i++) {
      mulSum += arr[i] * (sum[n] - sum[i]);
    }
    
    System.out.println(mulSum);
  }
  
}