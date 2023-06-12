import java.util.Scanner;

public class BOJ_3003 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int[] sampleArr = new int[] { 1, 1, 2, 2, 2, 8 };

    int[] inputArr = new int[6];

    for (int i = 0; i < inputArr.length; i++) {
      inputArr[i] = scanner.nextInt();
    }
    String ansStr = "";
    for (int i = 0; i < inputArr.length; i++) {
      int ans = 0;
      ans = sampleArr[i] - inputArr[i];
      ansStr += Integer.toString(ans) + " ";

    }

    System.out.println(ansStr);
    scanner.close();
  }
}
