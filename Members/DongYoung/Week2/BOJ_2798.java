import java.util.Scanner;

public class BOJ_2798 {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int N, M;

    String[] splitList = scanner.nextLine().split(" ");
    N = Integer.parseInt(splitList[0]);
    M = Integer.parseInt(splitList[1]);
    int[] cards = new int[N];

    for (int i = 0; i < N; i++) {
      cards[i] = scanner.nextInt();
    }
    // scanner.nextLine();
    // 블랙잭에서 M을 넘기지 않는 선에서 최대한의 수를 뽑아야하는데,
    // 카드를 전부 봐야하나 싶지만, 3가지 수를 선택하는 과정에서,
    // 3가지 수 선택에대한 순서를 고려하지 않기 때문에
    // nP3 이아닌 nC3 형태로 loop문을 만드는것이 효율적이다
    // nC2 형태의 루프문을 참고하여 nC3 루프문 설명

    // int testNum1 = N * (N - 1) / 2; // nC2
    // int testNum2 = 0;
    // for (int i = 0; i < N; i++) {
    // for (int j = i + 1; j < N; j++) {
    // testNum2++;
    // }
    // }
    // System.out.printf("%d, %d\n", testNum1, testNum2);

    int num = 0;
    loop1: for (int i = 0; i < N; i++) {
      for (int j = i + 1; j < N; j++) {
        for (int k = j + 1; k < N; k++) {
          int a1 = cards[i] + cards[j] + cards[k];
          if (a1 > num && a1 <= M) {
            num = a1;
            if (num == M) {
              break loop1;
            }
          }
        }
      }
    }
    System.out.println(num);
    scanner.close();
  }
}
