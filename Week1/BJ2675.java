import java.util.*; // java.util 에서 패키지의 모든 클래스를 가져오는 것

public class Main { // Main 이라는 공개 클래스를 정의
  public static void main(String[] args) { // 프로그램 시작점
    Scanner sc = new Scanner(System.in); // 'Scanner' 객체를 생성하는 코드 & System.in은 표준 입력 스트림

    int T = sc.nextInt();

    for (int i = 0; i < T; i++) {
      int R = sc.nextInt();
      String S = sc.next(); // nextLine() 을 쓰면 error!
      // nextLine() 으로 입력받으면 입력 과정에서 공백까지 읽어버리기 때문이다.

      for (int j = 0; j < S.length(); j++) {
        for (int k = 0; k < R; k++) { // R 만큼 반복 출력
          System.out.print(S.charAt(j));
        }
      }
      System.out.println();
    }
    sc.close();
  }
}