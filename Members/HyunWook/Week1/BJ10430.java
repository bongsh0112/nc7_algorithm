import java.util .*;  // java.util 에서 패키지의 모든 클래스를 가져오는 것

public class Main{  // Main 이라는 공개 클래스를 정의
  public static void main(String[] args) {  // 프로그램 시작점
    Scanner sc = new Scanner(System.in);

    int A = sc.nextInt();
    int B = sc.nextInt();
    int C = sc.nextInt();

    System.out.println((A+B)%C);
    System.out.println(((A%C)+(B%C))%C);
    System.out.println((A*B)%C);
    System.out.println(((A%C)*(B%C))%C);
  }
}