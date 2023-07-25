import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws Exception {
    String str = br.readLine();
    String[] num = str.split("[+-]");
    if (num.length == 2) {
      System.out.println(
          str.contains("+") ? Integer.parseInt(num[0]) + Integer.parseInt(num[1])
              : Integer.parseInt(num[0]) - Integer.parseInt(num[1]));
      return;
    } else if (!str.contains("-")) {
      System.out.println(Arrays.stream(num).mapToInt(Integer::parseInt).sum());
      return;
    }
    // 숫자가 3개 이상, -가 존재하는 경우
    String[] onlyPlus = str.replace("-", " ").split(" ");
    for (int i = 0; i < onlyPlus.length; i++) {
      // 문자열로 변환
      onlyPlus[i] = String.valueOf(Arrays.stream(onlyPlus[i].split("[+]")).mapToInt(Integer::parseInt).sum());
    }
    int sum = Integer.parseInt(onlyPlus[0]);
    for (int i = 1; i < onlyPlus.length; i++) {
      sum -= Integer.parseInt(onlyPlus[i]);
    }
    System.out.println(sum);
  }
}
