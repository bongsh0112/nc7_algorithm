import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws Exception {
    int[] JanJanBari = { 500, 100, 50, 10, 5, 1 };
    int JanDon = 1000 - Integer.parseInt(br.readLine());
    int cnt = 0;

    for (int JanBari : JanJanBari) {
      cnt += JanDon / JanBari;
      JanDon = JanDon % JanBari;
    }
    System.out.println(cnt);
  }
}
