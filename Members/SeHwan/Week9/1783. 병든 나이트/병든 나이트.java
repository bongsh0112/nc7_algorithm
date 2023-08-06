import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  
  public static void main(String[] args) throws IOException {
    
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    String[] str = bufferedReader.readLine().split(" ");
    
    long N = Long.parseLong(str[0]); // 세로 길이
    long M = Long.parseLong(str[1]); // 가로 길이
    
    long count = 0;
    if (N == 1) {
      count = 1;
    } else if (N == 2) {
      count = Math.min(4, (M + 1) / 2);
    } else {
      if (M >= 7) {
        count = M - 2;
      } else {
        count = Math.min(4, M);
      }
    }
    
    System.out.println(count);
    
  }
  
}