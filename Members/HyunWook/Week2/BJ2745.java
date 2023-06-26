
// 2745 진법 변환
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String n = sc.next();
    int b = sc.nextInt(); // 문자열을 변환할 진법

    long result = 0; // 변환된 정수값을 저장
    int idx = 0;// 현재 자릿수의 지수
    int num = 0;// 계산하기 위해 각 자리 숫자를 10진수로 바꿔준다
    for (int i = n.length() - 1; i >= 0; i--) { // 문자열의 가장 마지막 문자에 해당하는 인덱스는 n.length() - 1
      char c = n.charAt(i); // 가장 마지막 인덱스부터 시작하고, i를 1씩 감소시키면서 문자열의 앞쪽으로 이동합니다.
      if (c >= '0' && c <= '9')
        num = c - '0';// 0~9 사이는 그대로 출력
      else
        num = c - 55;// A~Z는 숫자로 변경
      result += num * Math.pow(b, idx++); // 진법에 해당하는 지수승 값을 계산
    }
    System.out.println(result);
  }
}

// Math.pow(); 함수란
// 주어진 밑(base)의 지수승(exponentiation) 값을 계산하는 메서드입니다.
// Math.pow는 다음과 같은 형식으로 사용됩니다
// double Math.pow(double base, double exponent)
// base: 밑으로 사용할 값
// exponent: 지수로 사용할 값

// Math.pow 함수는 base를 exponent만큼 거듭제곱하여 그 결과를 반환합니다.
// 반환값은 double 형식이므로 소수점 이하의 값을 포함할 수 있습니다.

// 예를 들어, Math.pow(2, 3)은 2의 3승을 계산하여 8을 반환합니다.
// 또 다른 예로, Math.pow(10, -2)는 10의 -2승을 계산하여 0.01을 반환합니다.

// Math.pow 함수는 수학적인 계산이나 지수 연산을 수행할 때 유용하게 사용됩니다.