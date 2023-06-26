import java.util.*; // java.util 에서 패키지의 모든 클래스를 가져오는 것

public class Main { // Main 이라는 공개 클래스를 정의
  public static void main(String[] args) { // 프로그램 시작점
    Scanner sc = new Scanner(System.in); // 'Scanner' 객체를 생성하는 코드 & System.in은 표준 입력 스트림

    int n = sc.nextInt(); // 사용자로부터 정수 값을 입력받아 n 변수에 저장합니다. 이 값은 반복 횟수를 결정하는 변수입니다.
    int sum = 0;

    for (int i = 1; i <= n; i++) {
      sum += i;
    }
    System.out.println(sum);
    sc.close();
  }
}