import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Set<String> list = new HashSet<>();

    int N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      String[] line = br.readLine().split(" ");
      if (line[1].equals("enter")) {
        list.add(line[0]);
      } else {
        list.remove(line[0]);
      }
    }
    StringBuffer sb = new StringBuffer();
    List<String> answer = new ArrayList<>(list);
    answer.sort(Comparator.reverseOrder());
    for (String name : answer) {
      sb.append(name + "\n");
    }
    System.out.println(sb);
  }
}
