import java.util.Scanner;

public class BOJ_2869 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int A;
    int B;
    int V;
    String[] inputArr = scanner.nextLine().split(" ");

    A = Integer.parseInt(inputArr[0]);
    B = Integer.parseInt(inputArr[1]);
    V = Integer.parseInt(inputArr[2]);

    int answer = 0;
    if ((V - A) % (A - B) == 0) {
      answer = (V - A) / (A - B) + 1;
    } else {
      answer = (V - A) / (A - B) + 2;
    }

    System.out.println(answer);
    scanner.close();
  }

}
