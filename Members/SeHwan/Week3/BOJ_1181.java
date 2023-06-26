import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class BOJ_1181 {

  public static void main(String[] args) throws IOException {

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer stringBuffer = new StringBuffer();

    HashSet<String> wordSet = new HashSet<>();

    int N = Integer.parseInt(bufferedReader.readLine());

    for (int i = 0; i < N; i++) {
      String word = bufferedReader.readLine();
      wordSet.add(word);
    }

    List<String> list = new ArrayList<>(wordSet); // 중복을 제거한 원소들을 ArrayList에 넣는다.
    list.sort(Comparator.naturalOrder()); // 우선 알파벳 순서대로 나열하고 그 다음에 길이 순으로 나열한다.

    for (int i = 0; i < list.size(); i++) {
      int targetLength = list.get(i).length();

      for (int j = 0; j < list.size(); j++) {
        if (targetLength < list.get(j).length()) {
          String temp = list.get(j);
          list.set(j, list.get(i));
          list.set(i, temp);
        }
      }
    }

    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i));
    }

  }

}
