

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer stringBuffer = new StringBuffer();
    
    int N = Integer.parseInt(bufferedReader.readLine());
    int[] sheets = new int[N];
    int[] sum = new int[N];
    
    String[] str = bufferedReader.readLine().split(" ");
    for (int i = 0; i < N; i++) {
      sheets[i] = Integer.parseInt(str[i]);
    }
    
    sum[0] = 0;
    for (int i = 1; i < N; i++) {
      sum[i] = (sheets[i-1] <= sheets[i]) ? sum[i - 1] : (sum[i - 1] + 1);
    }
    // 0 0 0 0 1 0 1 1 0
    // 0 0 0 0 1 1 2 3 0
    
    int Q = Integer.parseInt(bufferedReader.readLine());
    for (int i = 0; i < Q; i++) {
      str = bufferedReader.readLine().split(" ");
      int start = Integer.parseInt(str[0]);
      int end = Integer.parseInt(str[1]);
      stringBuffer.append(sum[end - 1] - sum[start - 1] + "\n");
    }
    
    System.out.println(stringBuffer.toString());
    
  }
  
}