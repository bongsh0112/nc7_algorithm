

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  
  public static void main(String[] args) throws IOException {
    
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer stringBuffer = new StringBuffer();
    
    String[] str = bufferedReader.readLine().split(" ");
    int N = Integer.parseInt(str[0]);
    int M = Integer.parseInt(str[1]);
    
    int[] num = new int[N + 1];
    str = bufferedReader.readLine().split(" ");
    for (int i = 1; i <= N; i++) {
      num[i] = num[i-1] + Integer.parseInt(str[i - 1]);
    }
    
    for (int i = 0; i < M; i++) {
      str = bufferedReader.readLine().split(" ");
      int start = Integer.parseInt(str[0]);
      int end = Integer.parseInt(str[1]);
      int sum = num[end] - num[start - 1];
      stringBuffer.append(sum + "\n");
    }
    
    System.out.println(stringBuffer.toString());
    
  }
  
}