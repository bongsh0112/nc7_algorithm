import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class Main {
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws Exception {
    br.readLine();
    int[] ary = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    TreeSet<Integer> set = new TreeSet<>();
    for (int num : ary)
      set.add(num);

    List<Integer> list = new ArrayList<>(set);
    StringBuffer sb = new StringBuffer();
    for (int num : ary) {
      sb.append(Collections.binarySearch(list, num) + " ");
    }

    System.out.println(sb);
  }
}
