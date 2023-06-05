import java.util.*; //java.util 패키지의 모든 클래스를 가져오는 것을 의미

public class Main { // Main 이라는 이름의 공개 클래스를 정의
  public static void main(String[] args) {  // main 메서드, 그러므로 해당 행이 프로그램의 시작점
    Scanner in = new Scanner(System.in);  // System.in은 표준 입력 스트림
    String id = in.next();  // 사용자로부터 문자열을 입력받아 'id'변수에 저장 & 'in.next()'는 사용자로부터 공백을 포함하지 않은 다음 문자열을 입력받는다.
    System.out.println(id + "??!"); // 입력된 'id' 값과 "??!"를 결합하여 출력
  }
}
// ??!