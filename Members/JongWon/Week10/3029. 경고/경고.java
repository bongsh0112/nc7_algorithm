import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws Exception {
    int[] 도착시간 = Arrays.stream(br.readLine().split(":")).mapToInt(Integer::parseInt).toArray();
    int[] 폭팔시간 = Arrays.stream(br.readLine().split(":")).mapToInt(Integer::parseInt).toArray();

    int 시 = 폭팔시간[0] - 도착시간[0];
    int 분 = 폭팔시간[1] - 도착시간[1];
    int 초 = 폭팔시간[2] - 도착시간[2];

    if (시 == 0 && 분 == 0 && 초 == 0) {
      System.out.println("24:00:00");
      return;
    }
    if (초 < 0) {
      초 += 60;
      분--;
    }
    if (분 < 0) {
      분 += 60;
      시--;
    }
    if (시 < 0) {
      시 += 24;
    }

    System.out.printf("%02d:%02d:%02d\n", 시, 분, 초);
  }
}
