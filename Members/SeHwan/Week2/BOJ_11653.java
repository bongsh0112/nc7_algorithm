package Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11653 {

//  16020KB	188ms

  public static void main(String[] args) throws IOException {

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer stringBuffer = new StringBuffer();

    int num = Integer.parseInt(bufferedReader.readLine());

    int startNum = 2;
    while (true) {

      if (num == 1) {
        break;
      }

      if (num % startNum != 0) {
        startNum++;
      } else {
        num = num / startNum;
        stringBuffer.append(startNum + "\n");
        startNum = 2;
      }
    }

    System.out.println(stringBuffer.toString());

  }
}
