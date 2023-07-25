package Members.DongYoung.Week8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

import java.util.Scanner;

public class BOJ_1931 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    scanner.nextLine();
    ArrayList<String[]> list = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      list.add(scanner.nextLine().split(" "));
    }

    Collections.sort(list, (a, b) -> {
      // 1. 끝에값 비교
      int a1 = Integer.parseInt(a[1]);
      int a0 = Integer.parseInt(a[0]);
      int b1 = Integer.parseInt(b[1]);
      int b0 = Integer.parseInt(b[0]);

      if (a1 != b1) {
        return a1 - b1;
      } else {
        return a0 - b0;
      }
    });
    int cnt = 0;
    int stN = 0;
    int endN = 0;
    for (int i = 0; i < N; i++) {
      int a1 = Integer.parseInt(list.get(i)[1]);
      int a0 = Integer.parseInt(list.get(i)[0]);

      if (endN <= a0) {
        cnt++;
        stN = a0;
        endN = a1;
      }

    }
    System.out.println(cnt);

  }

}
