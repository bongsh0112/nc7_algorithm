import java.util.Scanner;

public class BOJ_2738 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int row;
    int column;
    String[] strSplit = scanner.nextLine().split(" ");
    if (strSplit.length == 2) {
      row = Integer.parseInt(strSplit[0]);
      column = Integer.parseInt(strSplit[1]);
    } else {
      System.out.println("입력좀 잘하세요. 저 갑니다");
      return;
    }
    int[][] answer = new int[row][column];

    for (int i = 0; i < row * 2; i++) {
      strSplit = scanner.nextLine().split(" ");
      if (strSplit.length == column) {
        for (int j = 0; j < column; j++) {
          answer[i % row][j] += Integer.parseInt(strSplit[j]);
        }
      } else {
        System.out.println("입력좀 잘하세요. 저 갑니다");
        return;
      }
    }
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < column; j++) {
        System.out.printf("%d ", answer[i][j]);
      }
      System.out.println();
    }

  }
}