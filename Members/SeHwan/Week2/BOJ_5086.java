package Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5086 {

//  13984KB	112ms

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer sb = new StringBuffer();

    while (true) {

      String[] numbers = br.readLine().split(" ");
      int num1 = Integer.parseInt(numbers[0]);
      int num2 = Integer.parseInt(numbers[1]);

      if (num1 == num2) {
        System.out.println(sb.toString());
        break;
      }

      if (num1 / num2 > 1 && num1 % num2 == 0) {
        sb.append("multiple\n");
      } else if (num2 / num1 > 1&& num2 % num1 == 0) {
        sb.append("factor\n");
      } else {
        sb.append("neither\n");
      }

    }

  }
}

