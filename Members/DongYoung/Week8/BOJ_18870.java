package Members.DongYoung.Week8;

import java.util.Scanner;
import java.util.TreeSet;
import java.util.HashMap;
import java.lang.StringBuffer;

public class BOJ_18870 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    int[] arr = new int[N];

    scanner.nextLine();
    String[] split = scanner.nextLine().split(" ");
    TreeSet<Integer> set = new TreeSet<>();
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < N; i++) {
      int a = Integer.parseInt(split[i]);
      arr[i] = a;
      set.add(a);
    }
    int cnt = 0;
    for (int i : set) {
      map.put(i, cnt++);
    }
    StringBuffer sb = new StringBuffer("");
    for (int i = 0; i < N; i++) {
      sb.append(map.get(arr[i]) + " ");
    }
    System.out.println(sb.toString());
  }

}
