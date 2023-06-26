import java.util.*; // java.util 에서 패키지의 모든 클래스를 가져오는 것
import java.io.*;

public class Main {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int max = -1000000;
    int min = 1000000;

    for (int i = 0; i < n; i++) {
      int x = sc.nextInt();
      if (x >= max)
        max = x; // x를 기존의 최댓값(max)과 비교하여 더 큰 값이면 max를 업데이트합니다.
      if (x <= min)
        min = x; // x를 기존의 최솟값(min)과 비교하여 더 작은 값이면 min을 업데이트합니다.
    }
    System.out.println(min + " " + max);
  }
}