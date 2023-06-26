
// 2869 달팽이는 올라가고 싶다
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int A = sc.nextInt(); // 낮에 up 한 미터
    int B = sc.nextInt(); // 자는동안 down 한 미터
    int V = sc.nextInt(); // 나무 막대 높이 미터

    int day = (V - B) / (A - B); // (V - B) = 달팽이가 맨 위로 올라가야 할 높이
                                 // (A - B) = 달팽이가 하루에 올라갈 수 있는 높이
                                 // 달팽이가 정상으로 올라가기 위한 최소 일수
    if ((V - B) % (A - B) != 0) { // 나눈 나머지가 0이 아니라면 day에 1을 더하기
      day++;
    }
    System.out.println(day);
  }
}