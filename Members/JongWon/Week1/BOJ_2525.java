package Members.JongWon.Week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 오븐 시계
 * 첫째 줄에는 현재 시각이 나온다. 현재 시각은 시 A (0 ≤ A ≤ 23) 와 분 B (0 ≤ B ≤ 59)가 정수로 빈칸을 사이에 두고
 * 순서대로 주어진다. 두 번째 줄에는 요리하는 데 필요한 시간 C (0 ≤ C ≤ 1,000)가 분 단위로 주어진다.
 */
public class BOJ_2525 {
  public static void main(String[] args) throws Exception {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      String[] times = br.readLine().split(" ");
      int A = Integer.parseInt(times[0]);
      int B = Integer.parseInt(times[1]);
      int C = Integer.parseInt(br.readLine());

      // 데이터 검증
      if (A < 0 || A > 23 || B < 0 || B > 59 || C < 0 || C > 1000) {
        return;
      }

      int duringHour = C / 60; // 소요 시간
      int duringMin = C % 60; // 소유 분

      if (B + duringMin >= 60) {
        duringHour++;
      }
      B = (B + duringMin >= 60) ? (B + duringMin) - 60 : B + duringMin;
      A = (A + duringHour >= 24) ? (A + duringHour) - 24 : A + duringHour;

      System.out.println(A + " " + B);
    }
  }
}
