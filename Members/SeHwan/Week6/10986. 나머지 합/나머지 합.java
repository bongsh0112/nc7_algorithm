

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    String[] str = bufferedReader.readLine().split(" ");
    int N = Integer.parseInt(str[0]);
    int M = Integer.parseInt(str[1]);

    long count = 0;
    long[] mod = new long[M];
    long[] sum = new long[N + 1];
    
    str = bufferedReader.readLine().split(" ");
    for (int i = 1; i <= N; i++) {
      sum[i] = sum[i - 1] + Long.parseLong(str[i - 1]);
      if (sum[i] % M == 0) {
        count++;
      }
      mod[(int) (sum[i] % M)] += 1;
    }
    
    for (int i = 0; i < M; i++) {
      count += mod[i] * (mod[i] - 1) / 2;
    }
    
    System.out.println(count);
    
  }
  
}