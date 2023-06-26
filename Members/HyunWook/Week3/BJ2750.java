
// 2750 수 정렬하기
import java.util.Scanner;
import java.util.Arrays; // Arrays.sort 메서드 활용

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt(); // 정렬할 수의 개수 N
    int num[] = new int[N]; // 배열 크기를 N 만큼으로 설정

    for (int i = 0; i < N; i++) {
      num[i] = sc.nextInt(); // N번 동안 수를 입력받아 반복하여 num에 저장
    }
    Arrays.sort(num); // num을 오름차순으로 정렬하는 메서드
    for (int i = 0; i < N; i++) {
      System.out.println(num[i]); // 반복문을 통해 정렬된 num의 원소를 하나씩 출력
    }
  }
}