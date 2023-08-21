import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  private static int N, M;

  public static void main(String[] args) throws Exception {
    Set<String> s = new HashSet<>();
    br.readLine();

    StringTokenizer st = new StringTokenizer(br.readLine());
    while (st.hasMoreTokens())
      s.add(st.nextToken());

    br.readLine();

    String[] a = br.readLine().split(" ");
    System.out.println(Arrays.stream(a).map(o -> s.contains(o) ? String.valueOf(1) : String.valueOf(0))
        .collect(Collectors.joining(" ")));
  }
}
