
import java.util.Scanner;

public class BOJ_10798 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String[] StringArr = new String[5];

    int maxNo = 0;
    for (int i = 0; i < 5; i++) {
      String str = scanner.nextLine();
      StringArr[i] = str;
      if (maxNo < str.length()) {
        maxNo = str.length();
      }

    }
    String answer = "";
    for (int j = 0; j < maxNo; j++) {
      for (int i = 0; i < StringArr.length; i++) {
        if (j >= StringArr[i].length()) {
          continue;
        }
        answer += StringArr[i].charAt(j);
      }
    }

    System.out.println(answer);
  }
}
