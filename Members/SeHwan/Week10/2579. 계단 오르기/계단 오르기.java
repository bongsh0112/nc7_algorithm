import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  
  public static void main(String[] args) throws IOException {
    
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder stringBuilder = new StringBuilder();
    
    int N = Integer.parseInt(bufferedReader.readLine());
    int[] stairs = new int[N + 1];
    int[] scores = new int[N + 1];
    
    for (int i = 1; i <= N; i++) {
      int n = Integer.parseInt(bufferedReader.readLine());
      stairs[i] = n;
    }
    
    scores[1] = stairs[1]; // 첫 계단
    
    if (N >= 2) { // 두 번째 계단은 무조건 두개 다 밟는다
      scores[2] = stairs[1] + stairs[2];
    }
    
    for (int i = 3; i <= N; i++) {
      scores[i] = Math.max(scores[i - 2], scores[i - 3] + stairs[i - 1]) + stairs[i];
      /**
       * 마지막에 stairs[i] 를 더해주는 이유는 그전까지 계단을 밟다가 마지막 칸의 계단은 무조건 밟기 때문이다
       * scores[i - 2] 와 scores[i - 3] + stairs[i - 1] 을 비교하여 더 큰 값이 나오는 이유는 3칸 연속으로 밟으면 안되기 때문이다.
       */
    }
    
    System.out.println(scores[N]);
  }
  
}