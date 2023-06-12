import java.util.Scanner;

public class BOJ_11005 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int No;
    int zinbub;
    String str = scanner.nextLine();
    String[] strList = str.split(" ");
    No = Integer.parseInt(strList[0]);
    zinbub = Integer.parseInt(strList[1]);
    String answer = "";
    while (No >= 0) {
      int remainder = No % zinbub;
      if (remainder < 10) {
        answer = String.valueOf(remainder) + answer;
      } else {
        answer = (char) ((char) (remainder - 10) + 'A') + answer;
      }

      if (No / zinbub == 0) {
        break;
      } else {
        No = No / zinbub;
      }
    }
    System.out.println(answer);
    scanner.close();
  }
}
