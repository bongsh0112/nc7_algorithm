import java.util.*; // java.util 에서 패키지의 모든 클래스를 가져오는 것

public class Main { // Main 이라는 공개 클래스를 정의
  public static void main(String[] args) { // 프로그램 시작점
    Scanner sc = new Scanner(System.in); // 'Scanner' 객체를 생성하는 코드 & System.in은 표준 입력 스트림

    int a = sc.nextInt(); //
    int b = sc.nextInt(); //
    int c = sc.nextInt(); //

    if (a == b && a == c && b == c) { // 같은 눈이 3개일 경우
      System.out.println(10000 + a * 1000);
    } else if (a == b || a == c) { // 같은 눈이 2개일 경우
      System.out.println(1000 + a * 100);
    } else if (b == c) { // 같은 눈이 2개일 겅우
      System.out.println(1000 + b * 100);
    } else { // 모두 다른 경우
      System.out.println(Math.max(a, Math.max(b, c)) * 100); // 가장 큰 눈 * 100
    }
    sc.close();
  }
}