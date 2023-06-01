import java.util.Scanner;

public class BOJ_10818 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();
    String str = scanner.nextLine();
    str = scanner.nextLine();

    var strList = str.split(" ");
    if (strList.length == n) {
      int maxNum = Integer.parseInt(strList[0]);
      int minNum = Integer.parseInt(strList[0]);
      for (int i = 0; i < strList.length; i++) {
        int compareNum = Integer.parseInt(strList[i]);

        if (compareNum > maxNum) {
          maxNum = compareNum;
        } else if (compareNum < minNum) {
          minNum = compareNum;
        }
      }
      System.out.print(minNum);
      System.out.print(' ');
      System.out.print(maxNum);
    }
    scanner.close();

  }

}
