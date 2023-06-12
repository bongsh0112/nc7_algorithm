import java.util.*; // java.util 에서 패키지의 모든 클래스를 가져오는 것

public class Main { // Main 이라는 공개 클래스를 정의
  public static void main(String[] args) { // 프로그램 시작점
    Scanner sc = new Scanner(System.in); // 'Scanner' 객체를 생성하는 코드 & System.in은 표준 입력 스트림

    int h = sc.nextInt(); // 8시 => 7시
    int m = sc.nextInt(); // 25분 => 40분

    if (m < 45) { // 현재시간이 45분 미만일 때
      h = h - 1; // 시간은 -1
      m = 15 + m; // 분은 45분에서 현재분을 뺀 값을 60 분에서 빼준다.
      if (h < 0) { // 현재시간이 00시 미만일 때 현재시간 + 24시를 해준다.
        h = h + 24;
      }
    } else { // 현재분이 45분이상일때는 그냥 현재분에서 45분 빼기
      m = m - 45;
    }

    System.out.printf("%d %d", h, m);
    sc.close();
  }
}