import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 이거 Merge Sort자나...?
 * https://steady-coding.tistory.com/637
 */
public class Main {

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws Exception {
    int K = Integer.parseInt(br.readLine());
    List<List<Integer>> trees = new ArrayList<>();

    // 트리 초기화
    for (int i = 0; i < K; i++)
      trees.add(new ArrayList<Integer>());

    int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    divideTree(numbers, trees, 0, numbers.length, 0);

    StringBuilder sb = new StringBuilder();
    for (List<Integer> tree : trees) {
      for (Integer node : tree)
        sb.append(node + " ");
      sb.append("\n");
    }
    System.out.println(sb);
  }

  private static void divideTree(int[] numbers, List<List<Integer>> trees, int st, int ed, int depth) {
    if (st >= ed)
      return;

    int mid = (st + ed) / 2;
    trees.get(depth).add(numbers[mid]);
    // 좌측 트리
    divideTree(numbers, trees, st, mid, depth + 1);
    // 우측 트리
    divideTree(numbers, trees, mid + 1, ed, depth + 1);
  }
}
