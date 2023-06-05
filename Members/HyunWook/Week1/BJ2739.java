import java.util.*; // java.util 에서 패키지의 모든 클래스를 가져오는 것

public class Main { // Main 이라는 공개 클래스를 정의
  public static void main(String[] args) { // 프로그램 시작점
    Scanner sc = new Scanner(System.in); // 'Scanner' 객체를 생성하는 코드 & System.in은 표준 입력 스트림

    int num = sc.nextInt(); //

    for (int i = 1; i < 10; i++) {
      System.out.println(num + " * " + i + " = " + num * i);
    }
    sc.close();
  }
}