import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    Map<Integer, ArrayList<String>> sort = new HashMap<>();

    int max = Integer.MIN_VALUE;
    // 나이는 1보다 크거나 같으며, 200보다 작거나 같은 정수
    for (int i = 1; i <= 200; i++) {
      sort.put(i, new ArrayList<>());
    }

    for (int i = 0; i < N; i++) {
      String[] line = br.readLine().split(" ");
      int age = Integer.parseInt(line[0]);
      max = Math.max(max, age);
      sort.get(age).add(line[1]);
    }
    StringBuffer sb = new StringBuffer();
    for (int i = 1; i <= max; i++) {
      List temp = sort.get(i);

        for (int j = 0; j < temp.size(); j++) {
            sb.append(i + " " + temp.get(j) + "\n");
        }
     
    }
    System.out.println(sb);
  }
}
