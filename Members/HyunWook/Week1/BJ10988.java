import java.util.*; // java.util 에서 패키지의 모든 클래스를 가져오는 것

public class Main { // Main 이라는 공개 클래스를 정의
  public static void main(String[] args) { // 프로그램 시작점
    Scanner sc = new Scanner(System.in); // 'Scanner' 객체를 생성하는 코드 & System.in은 표준 입력 스트림

    String str = sc.next();
    boolean checked = true; // 불리언 변수를 true로 초기화합니다

    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
        checked = false;
        break;
        // 문자열의 첫 번째 문자부터 마지막 문자까지 반복하면서,
        // 대칭되는 문자끼리 비교
        // 만약 문자열의 i번째 문자와 대칭되는 str.length() - 1 - i번째 문자가 다르다면,
        // checked를 false로 변경하고 반복문을 종료합니다.
      }
    }
    if (checked == true) {
      System.out.println(1);
    } else {
      System.out.println(0);
      // 반복문이 종료된 후에 checked 값을 확인하여 회문인지 아닌지를 판별합니다.
      // checked가 true라면, 회문이므로 1을 출력합니다.
      // checked가 false라면, 회문이 아니므로 0을 출력합니다.

      sc.close();
    }
  }
}