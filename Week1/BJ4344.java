import java.util.*; // java.util 에서 패키지의 모든 클래스를 가져오는 것

public class Main { // Main 이라는 공개 클래스를 정의
  public static void main(String[] args) { // 프로그램 시작점
    Scanner sc = new Scanner(System.in); // 'Scanner' 객체를 생성하는 코드 & System.in은 표준 입력 스트림

    int[] arr; // 학생들의 성적을 저장

    int testcase = sc.nextInt();

    for (int i = 0; i < testcase; i++) {

      int N = sc.nextInt(); // 학생 수
      arr = new int[N];
      double sum = 0; // 성적 누적 합 변수

      // 성적 입력부분
      for (int j = 0; j < N; j++) {
        int val = sc.nextInt(); // 성적 입력
        arr[j] = val;
        sum += val; // 성적 누적 합
      }

      double mean = (sum / N);
      double count = 0; // 평균 넘는 학생 수 변수

      // 평균 넘는 학생 비율 찾기
      for (int j = 0; j < N; j++) {
        if (arr[j] > mean) {
          count++;
        }
      }
      System.out.printf("%.3f%%\n", (count / N) * 100);
    }
    sc.close();
  }
}