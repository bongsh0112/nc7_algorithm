import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
  
  public static void main(String[] args) throws IOException {
    
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    
    String[] str = bufferedReader.readLine().split(" ");
    int N = Integer.parseInt(str[0]);
    int K = Integer.parseInt(str[1]);
    
    int[] money = new int[N];
    for (int i = 0; i < N; i++) {
      money[i] = Integer.parseInt(bufferedReader.readLine());
    }
    
    int count = 0;
    for (int i = N - 1; i >= 0; i--) {
      if (K / money[i] == 0) {
        continue;
      }
      count += K / money[i];
      K = K % money[i];
    }
    
    System.out.println(count);
    
  }
  
}