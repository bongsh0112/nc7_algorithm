import java.util.Scanner;

public class BOJ_3003 {
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);
    final int[] arr = {1,1,2,2,2,8};

    for (int i = 0; i < 6; i++) {
      arr[i] -= sc.nextInt();
    }
    sc.close();
    for (int i : arr) {
      System.out.print(i + " ");
    }
  }
}
