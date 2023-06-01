
//1998년생인 내가 태국에서는 2431년생?
import java.util.Scanner;

public class BOJ_18108 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int inputNum = 0;
    inputNum = scanner.nextInt();
    inputNum = inputNum - 543;
    System.out.println(inputNum);
    scanner.close();
  }
}