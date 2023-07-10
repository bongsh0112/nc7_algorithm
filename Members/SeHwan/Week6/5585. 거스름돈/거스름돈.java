import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    
    int money = Integer.parseInt(bufferedReader.readLine());
    int remain = 1000 - money;
    int[] change = new int[]{500, 100, 50, 10, 5, 1};
    int count = 0;
    
    for (int i = 0; i < change.length; i++) {
      count += remain / change[i];
      remain = remain % change[i];
    }
    
    System.out.println(count);
    
  }

}