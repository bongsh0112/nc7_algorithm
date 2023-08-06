import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  
  public static void main(String[] args) throws IOException {
    
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    
    int N = Integer.parseInt(bufferedReader.readLine());
    int count = 0;
    
    while (N > 0) {
      if (N > 3) {
        N -= 3;
        count++;
      } else {
        N -= 1;
        count++;
      }
    }
    
    System.out.println(count % 2 == 0 ? "CY" : "SK");
    
  }
  
}