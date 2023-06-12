package Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1978 {

//  	14248KB	128ms

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer sb = new StringBuffer();

    int N = Integer.parseInt(br.readLine());
    String[] str = br.readLine().split(" ");
    boolean isPrimeNum = false;
    int numOfPrimeNum = N;

    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(str[i]);
      if (num == 1) {
        numOfPrimeNum--;
        continue;
      }
      for (int j = 2; j < num; j++) {
        isPrimeNum = num % j == 0 ? false : true;
        if (!isPrimeNum) {
          numOfPrimeNum--;
          break;
        }
      }
    }

    sb.append(numOfPrimeNum);
    System.out.println(sb.toString());

  }

}

