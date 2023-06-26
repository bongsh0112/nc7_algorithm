package Members.DongYoung.Week3;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.lang.StringBuffer;

public class BOJ_10814 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    HashMap<Integer, ArrayList<String>> userMap = new HashMap<>();

    int N = scanner.nextInt();
    scanner.nextLine();

    for (int i = 0; i < N; i++) {
      String[] strList = scanner.nextLine().split(" ");
      if (strList.length == 2) {
        if ("".equals(strList[1])) {
          continue;
        }
        if (!userMap.containsKey(Integer.parseInt(strList[0]))) {
          userMap.put(Integer.parseInt(strList[0]), new ArrayList<String>());
        }
        userMap.get(Integer.parseInt(strList[0])).add(strList[1]);
      }
    }
    // StringBuffer sb = new StringBuffer();
    for (int i = 1; i <= 200; i++) {
      if (userMap.containsKey(i)) {
        ArrayList<String> list = userMap.get(i);

        for (int j = 0; j < list.size(); j++) {
          String a = list.get(j);
          // sb.append(i);
          // sb.append(" ");
          // sb.append(a);
          // sb.append("\n");
          System.out.printf("%d %s\n", i, a);
        }
      }
    }
  }
}
