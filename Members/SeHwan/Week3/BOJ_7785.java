import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_7785 {

//  63304KB	948ms

  public static void main(String[] args) throws IOException {

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer stringBuffer = new StringBuffer();

    int N = Integer.parseInt(bufferedReader.readLine());

    Map<String, String> peopleMap = new HashMap<>();
    for (int i = 0; i < N; i++) {
      String[] temp = bufferedReader.readLine().split(" ");
      peopleMap.put(temp[0], temp[1]);
    }

    String[] people = peopleMap.keySet().toArray(new String[0]);
    List<String> answer = new ArrayList<>();

    for (int i = 0; i < people.length; i++) {
      if (!peopleMap.get(people[i]).equals("leave")) {
        answer.add(people[i]);
      }
    }

    Collections.sort(answer, Comparator.reverseOrder());
    for(int i = 0; i < answer.size(); i++) {
      stringBuffer.append(answer.get(i) + "\n");
    }

    System.out.print(stringBuffer.toString());
  }

}
