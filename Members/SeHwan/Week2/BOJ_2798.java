package Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2798 {

  public static void main(String[] args) throws IOException {

//    14132KB	124ms

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer stringBuffer = new StringBuffer();

    String[] str = bufferedReader.readLine().split(" ");
    int N = Integer.parseInt(str[0]);
    int M = Integer.parseInt(str[1]);

    str = bufferedReader.readLine().split(" ");
    int[] cards = new int[str.length];
    for (int i = 0; i < str.length; i++) {
      cards[i] = Integer.parseInt(str[i]);
    }
    int max = 0; int sum = 0;

    for (int idx1 = 0; idx1 < cards.length; idx1++) { // 첫 번째 카드는 고정하고 찾아본다.
      for (int idx2 = 0; idx2 < cards.length && idx1 != idx2; idx2++) { // 첫 번째 카드와 동일하면 안된다.
        for (int idx3 = 0; idx3 < cards.length && idx2 != idx3; idx3++) { // 첫 번째 카드 != 두 번째 카드인 상황에서 두 번째 카드 != 세 번째 카드이어야 함.
          sum = cards[idx1] + cards[idx2] + cards[idx3];
          if (sum > M) {
            max = max;
            continue;
          } else {
            if (max < sum) {
              max = sum;
            }
          }
        }
      }
    }

    stringBuffer.append(max);
    System.out.println(stringBuffer.toString());
  }

}
