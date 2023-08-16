import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws Exception {
    String[] NM = br.readLine().split(" ");
    int N = Integer.parseInt(NM[0]);
    int M = Integer.parseInt(NM[1]);
    int[] 첫배열 = new int[N];
    int[] 둘배열 = new int[M];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++)
      첫배열[i] = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++)
      둘배열[i] = Integer.parseInt(st.nextToken());

    Arrays.sort(첫배열);
    Arrays.sort(둘배열);

    int 정답[] = new int[N + M];
    int 정답인덱스 = 0;
    int 첫인덱스 = 0;
    int 둘인덱스 = 0;

    while (첫인덱스 < N || 둘인덱스 < M) {
      if (첫인덱스 >= N) {
        정답[정답인덱스++] = 둘배열[둘인덱스++];
        continue;
      }
      if (둘인덱스 >= M) {
        정답[정답인덱스++] = 첫배열[첫인덱스++];
        continue;
      }
      정답[정답인덱스++] = 첫배열[첫인덱스] <= 둘배열[둘인덱스] ? 첫배열[첫인덱스++] : 둘배열[둘인덱스++];
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N + M; i++)
      sb.append(정답[i] + " ");
    System.out.println(sb);
  }
}
