import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  
  public static void main(String[] args) throws IOException {
    
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    
    int sum = 0;
    int sub = Integer.MIN_VALUE;
    int answer = 0;
    for (int i = 0; i < 10; i++) {
      int score = Integer.parseInt(bufferedReader.readLine());
      sum += score;
      
      if (Math.abs(sum - score - 100) < sum - 100) {
        sum = sum - score;
        break;
      }
    }
    
    System.out.println(sum);
    
  }
  
}