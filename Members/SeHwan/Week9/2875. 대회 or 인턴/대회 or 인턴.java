import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  
  public static void main(String[] args) throws IOException {
    
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    String[] str = bufferedReader.readLine().split(" ");
    
    int N = Integer.parseInt(str[0]); // 여학생
    int M = Integer.parseInt(str[1]); // 남학생
    int K = Integer.parseInt(str[2]); // 인턴쉽
    
    int teams = 0;
    
    for (int i = 0; i <= K; i++) {
      int w = N - i;
      int m = M - (K - i);
      if (w >= m * 2) {
        teams = Math.max(teams, m);
      } else {
        teams = Math.max(teams, w / 2);
      }
    }
    
    System.out.println(teams);
    
  }
  
}