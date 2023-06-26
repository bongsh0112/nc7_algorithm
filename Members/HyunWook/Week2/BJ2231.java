
// 2231 분해합
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int check = 0; // 생성자의 유무를 판별하기 위한 변수 check를 초기화합니다. 생성자를 찾으면 check 값이 1로 변경됩니다.

    for (int i = 0; i < n; i++) { // 생성자 후보를 확인하기 위해 0부터 n-1까지의 숫자에 대해 반복,
      int con = i; // 생성자 후보인 i를 변수 con에 저장
      int sum = con; // 생성자 후보인 con 값을 변수 sum에 저장
      while (con > 0) { // 생성자 후보의 각 자릿수를 계산하기 위한 반복
        sum = sum + con % 10; // con % 10은 con의 일의 자리 숫자를 구하는 연산
        con = con / 10; // con의 일의 자리 숫자를 제거하는 역할
      }
      if (sum == n) { // 생성자 후보와 생성자 후보의 각 자릿수의 합이 n과 같은지 확인합니다.
        check++; // 같은 경우에는 생성자를 찾았으므로, check 값을 증가시키고
        System.out.println(i); // 해당 생성자 값을 출력한 후
        break; // 반복문을 종료
      }
    }
    if (check == 0) { // 생성자를 찾지 못한 경우 check가 여전히 0인 경우를 의미하며,
      System.out.println(0); // 생성자가 없다는 것을 의미하므로 0을 출력합니다.
    }
  }
}
