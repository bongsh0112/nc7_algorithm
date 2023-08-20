import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
  
  static int N;
  static List<Integer>[] tree = new ArrayList[N];
  static int count = 0;
  
  public static void main(String[] args) throws IOException {
    
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    long S = Long.parseLong(bufferedReader.readLine());
    long sum = 0;
    int count = 0;
    
    int n = 1;
    while (sum <= S) { // 그냥 1부터 쭉 더해서 S보다 큰 값을 찾으면 count에서 -1
      sum += n;
      count++;
      n++;
    }
    
    System.out.println(count - 1);
    
  }
  
}