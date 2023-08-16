import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  
  public static void main(String[] args) throws IOException {
    
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder stringBuilder = new StringBuilder();
    
    String[] str = bufferedReader.readLine().split(" ");
    int N = Integer.parseInt(str[0]);
    int X = Integer.parseInt(str[1]);
    
    str = bufferedReader.readLine().split(" ");
    int[] arr = new int[N];
    
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(str[i]);
    }
    
    int count = 1;
    int max = 0;
    int sum = 0;
    
    for (int i = 0; i < X; i++) {
      sum += arr[i]; // 첫 X일 동안 방문자수 집계
    }
    max = sum; // max로 설정
    
    for (int i = X; i < N; i++) {
      sum += arr[i] - arr[i - X]; // i를 1씩 늘리면서 X일 동안의 방문자수 집계
      if (max == sum) count++;
      else if (max < sum) {
        max = sum;
        count = 1;
      }
    }
    
    if (max == 0) {
      System.out.println("SAD");
    } else {
      System.out.println(max);
      System.out.println(count);
    }
    
  }
  
}