import java.util.*; // java.util 에서 패키지의 모든 클래스를 가져오는 것

public class Main { // Main 이라는 공개 클래스를 정의
  public static void main(String[] args) { // 프로그램 시작점
    Scanner sc = new Scanner(System.in); // 'Scanner' 객체를 생성하는 코드 & System.in은 표준 입력 스트림
    int n = sc.nextInt(); // 사용자로부터 정수값을 입력받아 'n' 변수에 저장
    int m = sc.nextInt(); // 사용자로부터 정수값을 입력받아 'm' 변수에 저장

    System.out.println(n * (m % 10)); // m을 10으로 나누어 나머지 값을 n에 곱한 값
    System.out.println(n * (m % 100 / 10)); // m을 100으로 나눈 나머지 값을 10으로 나누어 몫을 n에 곱한 값
    System.out.println(n * (m / 100)); // m을 100으로 나눈 몫을 n에 곱한 값
    System.out.println(n * m); // n 과 m 을 곱한 값

    sc.close();
  }
}