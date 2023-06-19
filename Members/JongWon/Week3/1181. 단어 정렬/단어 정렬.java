import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Main {
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static Map<Integer, Set<String>> wordSort = new HashMap<>();

  public static void main(String[] args) throws Exception {
    for (int i = 0; i <= 50; i++) { // Init
      wordSort.put(i, new TreeSet<String>());
    }

    int N = Integer.parseInt(br.readLine());

    int lengthMax = Integer.MIN_VALUE;
    for (int i = 0; i < N; i++) {
      String word = br.readLine();
      lengthMax = Math.max(lengthMax, word.length());
      wordSort.get(word.length()).add(word);
    }

    StringBuffer sb = new StringBuffer();
    for (int i = 0; i <= lengthMax; i++) {
      Set<String> tempList = wordSort.get(i);
      if (tempList.size() == 0)
        continue;

      for (String word : tempList) {
        sb.append(word + "\n");
      }

    }

      System.out.println(sb);
  }
}