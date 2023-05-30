
//꼬마정민
import java.util.Scanner;

public class bj11382 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    long[] nums = new long[3];

    for (int i = 0; i < nums.length; i++) {
      nums[i] = scanner.nextInt();
    }
    long sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
    }
    System.out.println(sum);

    scanner.close();
  }
}