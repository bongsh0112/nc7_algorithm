package Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2869 {

//  14208KB	124ms

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer sb = new StringBuffer();

    String[] str = br.readLine().split(" ");
    int up = Integer.parseInt(str[0]);
    int down = Integer.parseInt(str[1]);
    int height = Integer.parseInt(str[2]);

    int value = (height - up) / (up - down);
    int mod = (height - up) % (up - down);

    if (mod > 0) {
       value += 2;
    } else {
       value += 1;
    }

    System.out.println(value);

//    int go = up - down;
//    int days = 0;
//
//    while (true) {
//      if (height - up <= days * go) {
//        break;
//      }
//      days++;
//    }
//
//    System.out.println(days + 1);

  }

}
