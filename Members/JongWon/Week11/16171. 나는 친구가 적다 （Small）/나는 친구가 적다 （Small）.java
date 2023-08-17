import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws Exception {
    String word = br.readLine().replaceAll("[0-9]", "");
    String searchWord = br.readLine();
    System.out.println(word.contains(searchWord) ? 1 : 0);
  }
}
