import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws Exception {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      String[] splitLine = br.readLine().trim().split(" ");
      int A = Integer.parseInt(splitLine[0]);
      int B = Integer.parseInt(splitLine[1]);
      int V = Integer.parseInt(splitLine[2]);

      int answer = (V - A) % (A - B) == 0 ? (V - A) / (A - B) : ((V - A) / (A - B)) + 1;
      answer++;
      System.out.println(answer);
    }
  }
}
