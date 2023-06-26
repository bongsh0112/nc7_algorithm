import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      // 선언
      int N = Integer.parseInt(br.readLine());
      if(N<=1)
          return;
      if (N <= 3) {
        System.out.println(N);
        return;
      }

      List<Integer> list = new ArrayList<>();
      for (int i = 2; i <= N; i++) {
        if (i != N && N % i == 0) {
          list.add(i);
          N = N / i;
          i = 1;
          continue;
        }
        if (i == N) {
          list.add(i);
          break;
        }
      }
      System.out.println(list.stream().sorted().map(String::valueOf).collect(Collectors.joining("\n")));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
