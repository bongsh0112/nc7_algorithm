
// 24313 알고리즘 수업 - 점근접 표기
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int f1 = sc.nextInt(); // 사용자로부터 값을 입력받아 변수에 저장
    int f2 = sc.nextInt();
    int c = sc.nextInt();
    int n = sc.nextInt();

    int a = f1 * n + f2;
    int b = c * n;

    // a가 b보다 작거나 같고, f1이 c보다 작거나 같은 경우에는 1을 출력하고, 그렇지 않은 경우에는 0을 출력합니다.
    if (a <= b && f1 <= c) {
      System.out.println(1);
    } else {
      System.out.println(0);
    }
  }
}
