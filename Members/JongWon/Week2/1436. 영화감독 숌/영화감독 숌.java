import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int count = 1;
    int num = 666;
    // 666이 포함된 순서 나열을 하자면, 1666, 2666, 3666, 4666, 5666, 6660, 6661, 6662, 6663,
    // 6664, 6665,6666 ->
    while (count != N) {
      if ((++num + "").indexOf("666") != -1) {
        count++;
      }
    }
    System.out.println(num);
  }
}