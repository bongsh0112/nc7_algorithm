import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static int N, M;
  private static boolean[] isUsed = new boolean[10];
  private static int arr[] = new int[10];
  private static Set<String> set = new HashSet<>();
  private static List<String> list = new ArrayList<>();

  public static void main(String[] args) throws Exception {
    int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    N = input[0];
    M = input[1];
    tracking(0);
    StringBuilder sb = new StringBuilder();
    for (String str : list)
      sb.append(str + "\n");
    System.out.println(sb);
  }

  private static void tracking(int num) {
    if (num == M) {
      int[] copyAry = Arrays.copyOf(arr, M);
      Arrays.sort(copyAry);
      String str = Arrays.stream(copyAry).mapToObj(String::valueOf).collect(Collectors.joining(" "));
      if (!set.contains(str)) {
        list.add(str);
        set.add(str);
      }
      return;
    }

    for (int i = 1; i <= N; i++) {
      if (!isUsed[i]) {
        arr[num] = i;
        isUsed[i] = true;
        tracking(num + 1);
        isUsed[i] = false;
      }
    }
  }
}
