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
    
    int N = Integer.parseInt(bufferedReader.readLine());
    String[] str = bufferedReader.readLine().split(" ");
    
    int[] arr = new int[N];
    for (int i = 0; i < str.length; i++) {
      arr[i] = Integer.parseInt(str[i]);
    }
    
    Arrays.sort(arr);
    int[] sumArr = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      sumArr[i] = sumArr[i - 1] + arr[i - 1];
    }
    
    int sum = Arrays.stream(sumArr).sum();
    System.out.println(sum);
    
  }
  
}