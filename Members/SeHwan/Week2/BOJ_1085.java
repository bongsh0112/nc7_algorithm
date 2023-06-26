package Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BOJ_1085 {

//  14232KB	120ms

  public static void main(String[] args) throws IOException {

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    String[] str = bufferedReader.readLine().split(" ");
    int up = Integer.parseInt(str[3]) - Integer.parseInt(str[1]); // h - y
    int down = Integer.parseInt(str[1]); // y
    int left = Integer.parseInt(str[0]); // x
    int right = Integer.parseInt(str[2]) - Integer.parseInt(str[0]); // w - x

    List<Integer> arr = new ArrayList<>(Arrays.asList(up, down, left, right));

    int min = Collections.min(arr);
    System.out.println(min);
  }

}
