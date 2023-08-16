import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  
  public static void main(String[] args) throws IOException {
    
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int[] arr = new int[11]; // n은 항상 11보다 작다
    
    int T = Integer.parseInt(bufferedReader.readLine());
    for (int i = 1; i < 11; i++) {
      /** arr[n] = arr[n - 1] + arr[n - 2] + arr[n - 3]
       * 1, 2, 3은 자기자신으로 표현할 수 있는 숫자들이다.
       * 4 이상부터는 1, 2, 3으로 표현할 수 있는데, arr[n - k] 가 의미하는 바를 예를 들어서 설명해보면
       * 5 = 0 + 5 / 1 + 4 / 2 + 3 / 3 + 2 / 4 + 1 / 5 + 0 에서 쓸 수 없는 수인 0과 4를 사용하는 식을 제외하고
       * 2 + 3은 k = 3, 3 + 2는 k = 2, 4 + 1은 k = 1이라고 생각하면 된다.
       * 즉 마지막에 더해지는 수가 k이고 앞 2, 3, 4는 미리 계산된 결과값을 이용하여 사용하면 된다는 것.
       */
      if (i == 1) arr[i] = 1;
      else if (i == 2) arr[i] = 2;
      else if (i == 3) arr[i] = 4;
      else {
        arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
      }
    }
    
    for (int i = 0; i < T; i++) {
      int n = Integer.parseInt(bufferedReader.readLine());
      System.out.println(arr[n]);
    }
    
  }
  
}