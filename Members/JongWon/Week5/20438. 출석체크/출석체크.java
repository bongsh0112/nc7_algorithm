import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class Main {
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  private static int N, M, K, Q;
  public static void main(String[] args) throws Exception {
    String[] NMKQ = br.readLine().split(" ");
    N = Integer.parseInt(NMKQ[0]);
    K = Integer.parseInt(NMKQ[1]);
    Q = Integer.parseInt(NMKQ[2]);
    M = Integer.parseInt(NMKQ[3]);

    Set<Integer> banList = new HashSet<>();
    String[] banListStr = br.readLine().split(" ");
    for (int i = 0; i < K; i++) {
      banList.add(Integer.parseInt(banListStr[i]));
    }

    String[] startNums = br.readLine().split(" ");

    boolean[] check = new boolean[(3 + N) + 2];

    for (int i = 0; i < Q; i++) {
      int modNum = Integer.parseInt(startNums[i]);
      if (banList.contains(modNum))
        continue;
      for (int j = modNum; j <= N + 2; j += modNum) {
        if (!banList.contains(j))
          check[j] = true;
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int loop = 0; loop < M; loop++) {
      String[] sted = br.readLine().split(" ");
      int st = Integer.parseInt(sted[0]);
      int ed = Integer.parseInt(sted[1]);
      sb.append(IntStream.range(st, ed + 1).filter(i -> !check[i]).count() + "\n");
    }
    System.out.println(sb);
  }
}
