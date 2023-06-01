import java.util.Scanner;
import java.util.ArrayList;

public class BOJ_4344 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    final int N = scanner.nextInt();
    scanner.nextLine();
    double[] ansArr = new double[N];
    ArrayList<Integer> scores = new ArrayList<Integer>();
    int sum = 0;
    int score = 0;
    for (int i = 0; i < N; i++) {
      sum = 0;
      int N2 = scanner.nextInt();
      for (int j = 0; j < N2; j++) {
        score = scanner.nextInt();
        scores.add(score);
        sum += score;

      }
      scanner.nextLine();
      double average = sum / (double) N2;
      int count = 0;
      for (int j = 0; j < N2; j++) {
        if ((double) scores.get(j) > average) {
          count++;
        }
      }
      ansArr[i] = count / (double) N2;
      scores.clear();
    }

    for (int i = 0; i < N; i++) {
      double ans = java.lang.Math.round(ansArr[i] * 100000) / 1000.0;
      System.out.printf("%.3f%%%n", ans);
    }
    scanner.close();
  }
}
