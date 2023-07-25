package Members.DongYoung.Week8;

import java.util.Scanner;

public class BOJ_1541 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String str = scanner.nextLine();
    String[] split = str.split("[-|\\+]");
    String split1 = str.replaceAll("[0-9]", "");
    int sum = Integer.parseInt(split[0]);
    boolean st = false;
    for (int i = 0; i < split1.length(); i++) {
      if (split1.substring(i, i + 1).equals("-")) {
        st = true;
      }
      if (!st) {
        sum += Integer.parseInt(split[i + 1]);
      } else {
        sum -= Integer.parseInt(split[i + 1]);
      }
    }
    System.out.println(sum);
  }

}
