
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] ary = new int[N];
    for (int i = 0; i < N; i++) {
      ary[i] = Integer.parseInt(br.readLine());
    }

    int temp = 0;
    for (int i = 0; i < N - 1; i++) {
      for (int j = 0; j < N - 1 - i; j++) {
        if (ary[j] > ary[j + 1]) {
          temp = ary[j + 1];
          ary[j + 1] = ary[j];
          ary[j] = temp;
        }
      }
    }
    for (int i : ary) {
      System.out.println(i);
    }
  }
}
