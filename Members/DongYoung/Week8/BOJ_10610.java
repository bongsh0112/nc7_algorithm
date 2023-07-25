package Members.DongYoung.Week8;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Comparator;
import java.util.Collections;
import java.lang.StringBuffer;
import java.util.HashMap;

public class BOJ_10610 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Integer> list = new ArrayList<>();
    StringBuffer sb = new StringBuffer("");
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    map.put(0, new ArrayList<Integer>());
    map.put(1, new ArrayList<Integer>());
    map.put(2, new ArrayList<Integer>());
    char[] arr = scanner.nextLine().toCharArray();
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      int a = (arr[i] - '0') % 3;
      list.add(arr[i] - '0');
      map.get(a).add(arr[i] - '0');
      sum += arr[i] - '0';
    }
    Collections.sort(list, Comparator.reverseOrder());

    if (list.get(list.size() - 1) != 0 || sum % 3 != 0) {
      System.out.println(-1);
      return;
    }
    for (int i = 0; i < list.size(); i++) {
      sb.append(String.valueOf(list.get(i)));
    }
    System.out.println(sb.toString());

  }
}
