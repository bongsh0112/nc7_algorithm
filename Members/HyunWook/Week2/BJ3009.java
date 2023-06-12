
// 3009 네 번째 점
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int x1 = sc.nextInt();
    int y1 = sc.nextInt();
    int x2 = sc.nextInt();
    int y2 = sc.nextInt();
    int x3 = sc.nextInt();
    int y3 = sc.nextInt();

    // 네 번째 점 초기화
    int x4 = 0; // 찾아야 할 네 번째 x 좌표
    int y4 = 0; // 찾아야 할 네 번째 y 좌표

    // x 구하기
    if (x1 == x2) {
      x4 = x3;
    } else if (x2 == x3) {
      x4 = x1;
    } else {
      x4 = x2;
    }

    // y 구하기
    if (y1 == y2) {
      y4 = y3;
    } else if (y2 == y3) {
      y4 = y1;
    } else {
      y4 = y2;
    }

    // 입력된 세 점 중에서 중복되지 않은 x 좌표와 y 좌표를 찾아내어 네 번째 점의 좌표로 출력
    System.out.println(x4 + " " + y4);
  }
}