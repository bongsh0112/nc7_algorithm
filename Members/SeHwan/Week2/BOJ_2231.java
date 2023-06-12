package Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2231 {

//  14460KB	144ms

  public static void main(String[] args) throws IOException {

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer stringBuffer = new StringBuffer();

    String num = bufferedReader.readLine();
    int N = Integer.parseInt(num);
    int constructor = 0;

    for (int i = N - 1; i >= 0; i--) { // N - 1부터 내려간다
      int number = i;
      int sumOfDigit = 0; // 각 자리수 합

      while (number > 0) {
        sumOfDigit += number % 10;
        number /= 10;
        // 1의자리부터 오름차순으로 자릿수를 계속 더함.
      }

      if (sumOfDigit + i == N) { // 현재 숫자와 그 숫자의 모든 자릿수의 합이 주어진 숫자와 같으면. 즉 현재 숫자가 주어진 숫자의 생성자일때
        constructor = i;
      }
    }

    stringBuffer.append(constructor);
    System.out.println(stringBuffer.toString());
  }

}
