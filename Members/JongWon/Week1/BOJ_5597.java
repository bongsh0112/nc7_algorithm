package Members.JongWon.Week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 반복문 - 과제 안 내신분..?
 */
public class BOJ_5597 {
  public static final int STUDENT_NUM = 30;

  public static void main(String[] args) throws Exception {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      boolean[] isHomework = new boolean[STUDENT_NUM];
      Arrays.fill(isHomework, false); // 배열 초기화

      // 실행횟수
      for (int i = 0; i < STUDENT_NUM - 2; i++) {
        int N = Integer.parseInt(br.readLine());
        if (isStudentNum(N)) {
          return; // 학생 번호가 아닌 경우
        }
        // 1부터 할순있는데 그냥 이게 편함.
        isHomework[N - 1] = true;
      }

      // 과제 검증
      for (int i = 0; i < STUDENT_NUM; i++) {
        if (!isHomework[i]) {
          System.out.println(i + 1);
        }
      }
    }
  }

  private static boolean isStudentNum(int num) {
    return num < 1 || num > STUDENT_NUM;
  }
}
