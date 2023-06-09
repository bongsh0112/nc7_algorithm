package Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11005 {

  // ASCII -> A ~ Z : 65~90 => 10~35

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer sb = new StringBuffer();

    String[] str = br.readLine().split(" ");
    int num = Integer.parseInt(str[0]);
    int n = Integer.parseInt(str[1]);

    if (n < 2 || n > 36) {
      return;
    }

    // num을 n의 x제곱으로 나누었을 때 1보다 작게 나오는 x를 찾는다
    // => x + 1의 자리로 설정된다.
    int length = 1;

    for (int i = 0; i < 10; i++) {
      if (num / Math.pow(n, i) < n) {
        break;
      }
      length++;
    }

    int[] arr = new int[length];

    int result = 0;

    // 진법 변환 시 계속 나누면서 나머지를 높은자릿수 부터 채우기 때문에 이렇게 했음
    for (int i = length - 1; i >= 0; i--) {
      result = num % n;
      num = num / n;
      arr[i] = result;
    }

    for (int i = 0; i < length; i++) {
      if (arr[i] > 10) {
        sb.append((char) (arr[i] + 55));
      } else {
        sb.append(arr[i]);
      }
    }

    System.out.println(sb.toString().trim());
  }

}
