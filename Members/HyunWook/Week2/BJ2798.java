
// 2798 블랙잭
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt(); // 카드 개수
    int M = sc.nextInt(); // 블랙잭(넘지 않고 가까워여 하는 수)
    int sum = 0; // 카드 3장의 합
    int tmp = 0; // 새로운 근사치 값이 나오기 전까지 근사치 값

    int arr[] = new int[N]; // 카드들의 값을 저장

    for (int i = 0; i < N; i++) { // N번 반복하면서 arr 배열에 카드들의 값
      arr[i] = sc.nextInt();
    }

    for (int i = 0; i < N; i++) { // 첫번째 카드
      for (int j = i + 1; j < N; j++) { // 두번째 카드
        for (int k = j + 1; k < N; k++) { // 세번째 카드
          sum = arr[i] + arr[j] + arr[k]; // 3장의 카드 합

          if (tmp < sum && sum <= M) // 근사치(tmp) 보다 크고 블랙잭(M)보다 작거나 같으면 새로운 근사치 값을 갱신
            tmp = sum;
        }
      }
    }
    System.out.println(tmp); // 가장 가까운 블랙잭 합 출력
  }
}
