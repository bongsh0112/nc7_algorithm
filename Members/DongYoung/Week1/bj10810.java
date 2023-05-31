
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class bj10810 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n1 = scanner.nextInt();
    int n2 = scanner.nextInt();
    String nullStr = scanner.nextLine();
    ArrayList<String> list = new ArrayList<String>();
    for (int i = 0; i < n2; i++) {
      String str = scanner.nextLine();
      list.add(str);
    }
    int[] basketArr = new int[n1];
    Arrays.fill(basketArr, 0);

    for (int i = 0; i < n2; i++) {
      var nums = list.get(i).split(" ");
      int startNum = Integer.parseInt(nums[0]);
      int endNum = Integer.parseInt(nums[1]);
      int ballNum = Integer.parseInt(nums[2]);

      for (int j = startNum; j <= endNum; j++) {
        basketArr[j - 1] = ballNum;
      }
    }
    String ans = Integer.toString(basketArr[0]);
    for (int i = 1; i < basketArr.length; i++) {
      ans += ' ' + Integer.toString(basketArr[i]);
    }
    System.out.println(ans);
  }

}