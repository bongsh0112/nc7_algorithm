package Members.DongYoung.Week8;

import java.util.Scanner;
import java.util.ArrayList;
import java.lang.StringBuffer;
import java.util.StringTokenizer;

public class BOJ_16139 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String string = scanner.nextLine();
    ArrayList<Integer> list = new ArrayList<>();
    int N = scanner.nextInt();
    int[][] sums = new int[26][string.length() + 1];
    for (int i = 0; i < string.length(); i++) {
      int a1 = string.charAt(i) - 'a';
      for (int j = 0; j < 26; j++) {
        int a = 0;
        if (j == a1) {
          a = 1;
        }
        sums[j][i + 1] = sums[j][i] + a;
      }
    }
    scanner.nextLine();
    StringBuffer sb = new StringBuffer("");
    for (int i = 0; i < N; i++) {
      String[] split = scanner.nextLine().split(" ");
      int num = split[0].charAt(0) - 'a';
      int start = Integer.parseInt(split[1]);
      int end = Integer.parseInt(split[2]);
      sb.append((sums[num][end + 1] - sums[num][start]) + "\n");
    }
    // StringBuffer sb = new StringBuffer("");
    // for (int i = 0; i < list.size(); i++) {
    // sb.append(list.get(i) + "\n");
    // }
    System.out.println(sb.toString());
  }

}
