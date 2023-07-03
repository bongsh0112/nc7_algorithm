import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class Main {
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  private static int N, M, K, Q;
  // 3 ~ N+2 까지의 입장 번호를 학생은 받게 된다.
  // 출석코드를 보내면 -> 받은 학생은 본인의 '입장번호'의 배수인 학생한테 출석코드를 보낸다.
  // K명의 졸고있는 학생들은 출석코드를 제출하지도, 타인에게 보내지도 않는다.
  // 무작위 한명한테 출석코드를 보내는 행위를 Q번 반복한다.
  // 특정 구간의 입장번호를 받은 학생 중에 출석이 되지 않은 학생의 수를 구하고 싶다.

  // [1번 라인] N: 학생수, K: 졸고있는 학생 수, Q: 출석 코드를 보낼 학생수(TC), M:주어질 구간의 수
  // [2번 라인] 졸고있는 학생의 입장 번호들
  // [3번 라인] Q명의 출석코드를 받을 학생 번호
  // [4번 라인] M개의 줄 동안 구간의 범위 S, E가 공백을 두고 주어진다.

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
