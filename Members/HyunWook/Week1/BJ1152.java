import java.util.*; // java.util 에서 패키지의 모든 클래스를 가져오는 것

public class Main { // Main 이라는 공개 클래스를 정의
  public static void main(String[] args) { // 프로그램 시작점
    Scanner sc = new Scanner(System.in); // 'Scanner' 객체를 생성하는 코드 & System.in은 표준 입력 스트림

    String S = sc.nextLine(); // 한 라인 입력받기

    S = S.trim(); // 양쪽 공백제거
    String arr[] = S.split(" "); // 공백기준으로 스플릿

    if (arr.length == 1 && arr[0].equals("")) {
      System.out.println(0);
    } else {
      System.out.println(arr.length);
    }
    // 문자열 배열 arr의 길이가 1이고 첫 번째 요소가 빈 문자열인 경우,
    // 즉 입력된 문자열이 공백만 있는 경우에는 0을 출력합니다.
    // 그렇지 않은 경우, 즉 입력된 문자열에 단어가 있는 경우에는 배열의 길이를 출력합니다.
    sc.close();
  }
}