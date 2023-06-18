import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Set<String> wordList = new TreeSet<>();

    String[] NM = br.readLine().split(" ");

    int N = Integer.parseInt(NM[0]);
    int M = Integer.parseInt(NM[1]);

    for (int i = 0; i < N; i++) {
      wordList.add(br.readLine());
    }

    int cnt = 0;
    for (int i = 0; i < M; i++) {
      if (wordList.contains(br.readLine())) {
        cnt++;
      }
    }

    System.out.println(cnt);

  }
}
