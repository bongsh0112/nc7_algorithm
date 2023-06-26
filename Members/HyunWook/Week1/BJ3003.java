import java.util.*; // java.util 에서 패키지의 모든 클래스를 가져오는 것

public class Main { // Main 이라는 공개 클래스를 정의
  public static void main(String[] args) { // 프로그램 시작점
    Scanner sc = new Scanner(System.in); // 'Scanner' 객체를 생성하는 코드 & System.in은 표준 입력 스트림

    int king = 1;
    int queen = 1;
    int rook = 2;
    int bishop = 2;
    int knight = 2;
    int pawn = 8;

    king = king - sc.nextInt();
    queen = queen - sc.nextInt();
    rook = rook - sc.nextInt();
    bishop = bishop - sc.nextInt();
    knight = knight - sc.nextInt();
    pawn = pawn - sc.nextInt();

    // 참고로 출력형식을 보면 각 변수들사이에 공백으로 구분 된한 줄로 출력해야한다.
    // 즉, 개행(줄바꿈)이 발생하는 println을 쓰면 안된다.
    System.out.print(king + " ");
    System.out.print(queen + " ");
    System.out.print(rook + " ");
    System.out.print(bishop + " ");
    System.out.print(knight + " ");
    System.out.print(pawn);

    sc.close();
  }
}