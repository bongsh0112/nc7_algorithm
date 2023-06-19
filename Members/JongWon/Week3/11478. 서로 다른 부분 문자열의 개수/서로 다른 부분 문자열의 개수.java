import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.HashSet;
import java.util.Set;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Set<String> list = new HashSet<>();
    String word = br.readLine();

    for (int i = 1; i <= word.length(); i++) {
      for (int j = 0; j + i <= word.length(); j++) {
        list.add(word.substring(j, j + i));
      }
    }

    System.out.println(list.size());
  }
}
