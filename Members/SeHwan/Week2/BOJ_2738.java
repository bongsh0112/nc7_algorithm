package Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2738 {

  //17692KB	212ms

  public static void main(String[] args) throws IOException {

    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer sb = new StringBuffer();

    String[] rowCol = bf.readLine().split(" ");
    int row = Integer.parseInt(rowCol[0]);
    int col = Integer.parseInt(rowCol[1]);

    int[][] arr = new int[row][col];

    for (int i = 0; i < row; i++) {
      String[] str = bf.readLine().split(" ");
      for (int j = 0; j < col; j++) {
        int temp = Integer.parseInt(str[j]);
        arr[i][j] = temp;
      }
    }

    int[][] arr2 = new int[row][col];

    for (int i = 0; i < row; i++) {
      String[] str = bf.readLine().split(" ");
      for (int j = 0; j < col; j++) {
        int temp = Integer.parseInt(str[j]);
        arr2[i][j] = temp + arr[i][j];
        if (j == col - 1) {
          sb.append(arr2[i][j] + "\n");
          continue;
        }
        sb.append(arr2[i][j] + " ");
      }
    }

    System.out.println(sb.toString());

  }

}
