import java.util.Scanner;

public class BOJ_1546 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int N;
    N = scanner.nextInt();
    scanner.nextLine();
    int[] scoreArr = new int[N];
    int maxScore = 0;
    for (int i = 0; i < scoreArr.length; i++) {
      scoreArr[i] = scanner.nextInt();
      maxScore = java.lang.Math.max(maxScore, scoreArr[i]);
    }
    Double sum = 0.0;

    for (int i = 0; i < N; i++) {
      sum += (scoreArr[i] / (double) maxScore) * 100;
    }

    System.out.println(sum / N);
    scanner.close();

  }
}
