
// 1058 직사각형에서 탈출
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int x = sc.nextInt();
    int y = sc.nextInt();
    int w = sc.nextInt();
    int h = sc.nextInt();

    int x_min = Math.min(x, w - x); // x와 w - x 중 작은 값을 선택하여 x 축으로부터 가장 가까운 변까지의 거리를 계산
    int y_min = Math.min(y, h - y); // y와 h - y 중 작은 값을 선택하여 y 축으로부터 가장 가까운 변까지의 거리를 계산

    // x 축과 y 축으로부터 가장 가까운 변까지의 거리 중 작은 값을 선택
    System.out.println(Math.min(x_min, y_min));

  }
}