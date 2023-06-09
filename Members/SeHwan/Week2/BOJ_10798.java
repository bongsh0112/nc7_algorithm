package Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//14396KB	132ms

public class BOJ_10798 {

  public static void main(String[] args) throws IOException {

    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer sb = new StringBuffer();

    String[][] words = new String[5][15];
    int maxLength = 0; int row = 5;

    for (int i = 0; i < row; i++) {

      String[] word = bf.readLine().split("");
      if(maxLength < word.length) maxLength = word.length;

      for (int j = 0; j < word.length; j++) {
        words[i][j] = word[j];
      }
    }

    for (int i = 0; i < maxLength; i++) {
      for (int j = 0; j < 5; j++) {
        if(words[j][i] == null) continue;
        sb.append(words[j][i]);
      }
    }

    System.out.println(sb);

  }

}
