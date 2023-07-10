

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(bufferedReader.readLine());
    
    int five = N / 5;
    int three = 0;
    while (true) {
      if (five < 0) { // 4와 같은 값이 여기서 걸린다.
        System.out.println(-1);
        return;
      }
      if ((N - (5 * five)) % 3 == 0) { // 5개짜리로 가져간 후 3개로 나눈게 나누어 떨어진다면
         three = (N - (5 * five)) / 3;
        break;
      }
      five--;
    }
    
    System.out.println(five + three);
    
  }

}