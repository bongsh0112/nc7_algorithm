import java.util.*; // java.util 에서 패키지의 모든 클래스를 가져오는 것

public class Main { // Main 이라는 공개 클래스를 정의
  public static void main(String[] args) { // 프로그램 시작점
    Scanner sc = new Scanner(System.in); // 'Scanner' 객체를 생성하는 코드 & System.in은 표준 입력 스트림

    int h = sc.nextInt(); // 현재 시간
    int m = sc.nextInt(); // 현재 분
    int mm = sc.nextInt(); // 요리하는 시간

    h += mm / 60; // 요리시간이 60분 이상일 때 나눈 값을 h에 더한다
    m += mm % 60; // 요리시간을 60으로 나눈 몫을 m에 더한다

    if (m >= 60) {
      h += 1; // m이 60 이상이면 h에 1을 더한다
      m -= 60; // m이 60 이상일 때 60을 뺀다.
    }
    if (h >= 24) {
      h -= 24; // h가 24시이상일때 1씩 빼준다. (h가 00시일 수 있기 때문에)
    }

    System.out.println(h + " " + m);
    sc.close();
  }
}