package Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//14352KB	128ms

public class BOJ_11005 {

  // ASCII -> A ~ Z : 65~90 => 10~35

  //14352KB	128ms

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer sb = new StringBuffer();

    String[] str = br.readLine().split(" ");
    int num = Integer.parseInt(str[0]);
    int n = Integer.parseInt(str[1]);

    while (num > 0) {
      if ((num % n) >= 10) {
        sb.append((char) (num % n + 55));//        (char) (num % n - 10) + 'A'
        num = num / n;
      } else {
        sb.append(num % n);
        num = num / n;
      }
    }

    System.out.println(sb.reverse().toString());
  }

}
