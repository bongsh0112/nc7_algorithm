package Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3009 {
//  15896KB	152ms

  public static void main(String[] args) throws IOException {

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer token;

    int[] x = new int[3];
    int[] y = new int[3];
    for (int i = 0; i < 3; i++) {
      token = new StringTokenizer(bufferedReader.readLine());
      x[i] = Integer.parseInt(token.nextToken());
      y[i] = Integer.parseInt(token.nextToken());
    }

    int xResult = 0; int yResult = 0;
    if (x[0] == x[1]) {
      xResult = x[2];
    } else {
      xResult = x[0] == x[2] ? x[1] : x[0];
    }
    if (y[0] == y[1]) {
      yResult = y[2];
    } else {
      yResult = y[0] == y[2] ? y[1] : y[0];
    }

    System.out.println(xResult + " " + yResult);
  }
}
