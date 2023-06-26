import java.util.Scanner;

public class BOJ_16956 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String a = scanner.nextLine();
    int N = Integer.parseInt(a.split(" ")[0]);
    int M = Integer.parseInt(a.split(" ")[1]);

    char[][] field = new char[N][M];
    for (int i = 0; i < N; i++) {
      String str = scanner.nextLine();
      for (int j = 0; j < M; j++) {
        field[i][j] = str.charAt(j);
      }
    }
    boolean result = true;
    loop1: for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (field[i][j] == 'W') {
          // 위
          if (i > 0) {
            if (field[i - 1][j] == 'S') {
              result = false;
              break loop1;
            }
            if (field[i - 1][j] != 'W') {
              field[i - 1][j] = 'D';
            }

          }
          // 아래
          if (i < N - 1) {
            if (field[i + 1][j] == 'S') {
              result = false;
              break loop1;
            }
            if (field[i + 1][j] != 'W') {
              field[i + 1][j] = 'D';
            }
          }
          // 왼쪽
          if (j > 0) {
            if (field[i][j - 1] == 'S') {
              result = false;
              break loop1;
            }
            if (field[i][j - 1] != 'W') {
              field[i][j - 1] = 'D';
            }
          }
          // 오른쪽
          if (j < M - 1) {
            if (field[i][j + 1] == 'S') {
              result = false;
              break loop1;
            }
            if (field[i][j + 1] != 'W') {
              field[i][j + 1] = 'D';
            }
          }
        }
      }
    }
    if (result) {
      System.out.println(1);
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
          System.out.print(field[i][j]);
        }
        System.out.println();
      }
    } else {
      System.out.println(0);
    }
  }
}
