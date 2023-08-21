
import java.io.BufferedReader;
import java.io.InputStreamReader;

//https://velog.io/@nnnyeong/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%ED%92%80%EC%9D%B4-%EB%B6%84%EC%84%9D-BOJ-1789-%EC%88%98%EB%93%A4%EC%9D%98-%ED%95%A9
//이 공식이 왜 나오는지 모르겠다
public class Main {

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws Exception {
    long S = Long.valueOf(br.readLine());
    long left = 1, right = S;
    long answer = 0;
    while (left <= right) {
      long mid = (left + right) / 2;
      if (mid * (mid + 1) / 2 > S)
        right = mid - 1;
      else {
        answer = mid;
        left = mid + 1;
      }
    }
    System.out.println(answer);
  }
}
