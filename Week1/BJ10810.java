import java.util.*; // java.util 에서 패키지의 모든 클래스를 가져오는 것
import java.io.*;

public class Main {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt(); // 바구니의 개수
    int m = sc.nextInt(); // 골을 넣는 방법

    int[] answer = new int[n]; // answer는 길이가 n인 정수 배열로, 바구니에 들어있는 골의 개수를 저장합니다.

    for (int a = 0; a < m; a++) { // answer 배열의 값을 설정합니다. i부터 j까지의 인덱스에 k개의 골을 넣어줍니다.
      int i = sc.nextInt();
      int j = sc.nextInt();
      int k = sc.nextInt();

      for (int l = i - 1; l < j; l++) {
        answer[l] = k;
      }
    }

    for (int i = 0; i < n; i++) {
      System.out.print(answer[i] + " "); // answer 배열에 들어있는 골의 개수를 출력합니다.
    }
  }
}