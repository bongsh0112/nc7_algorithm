import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    List<Integer> scoreList = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      scoreList.add(Integer.parseInt(br.readLine()));
    }
    int sum = (int) scoreList.stream().mapToInt(i -> i).average().orElse(-1.0);
    scoreList.sort(Comparator.naturalOrder());
    int center = scoreList.get(2);

    System.out.println(sum + "\n" + center);
  }
}