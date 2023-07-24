import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws Exception {
    String s = br.readLine();
    if (!s.contains("0")) {
      System.out.println(-1);
      return;
    }
    int[] a = Arrays.stream(s.split("")).mapToInt(Integer::parseInt).toArray();
    if (Arrays.stream(a).sum() % 3 != 0) {
      System.out.println(-1);
      return;
    }
    Arrays.sort(a);
    System.out.println(new StringBuilder(
        Arrays.stream(a)
            .mapToObj(String::valueOf)
            .collect(Collectors.joining()))
        .reverse());
  }
}
