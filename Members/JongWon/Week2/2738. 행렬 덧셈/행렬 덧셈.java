import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      String[] NM = br.readLine().split(" ");
      int N = Integer.parseInt(NM[0]);
      int M = Integer.parseInt(NM[1]);

      int[][] A = new int[N][M];
      int[][] B = new int[N][M];

      StringBuffer sb = new StringBuffer();

      // Line 삽입
      for (int i = 0; i < N * 2; i++) {
        String[] line = br.readLine().split(" ");
        for (int j = 0; j < M; j++) {
          if (i < N)
            A[i][j] = Integer.parseInt(line[j]);
          else
            B[i - N][j] = Integer.parseInt(line[j]);
        }
      }

      IntStream.range(0, N)
          .forEach(i -> sb.append(
              IntStream.range(0, M)
                  .mapToObj(j -> String.valueOf(A[i][j] + B[i][j]))
                  .collect(Collectors.joining(" ")) + "\n"));

      System.out.println(sb.toString());

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}