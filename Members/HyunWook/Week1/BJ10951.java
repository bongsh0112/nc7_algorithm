import java.util.*; // java.util 에서 패키지의 모든 클래스를 가져오는 것
import java.io.*;

public class Main {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    while (sc.hasNextInt()) {
      // hasNextInt 메서드는 Scanner 객체가 다음으로 읽을 수 있는 정수가 있는지 여부를 확인합니다.
      // 반환값은 boolean 형식이며, 다음으로 읽을 수 있는 정수가 있을 경우 true를 반환하고,
      // 그렇지 않을 경우 false를 반환합니다.
      // 따라서, while (sc.hasNextInt())은 Scanner 객체에서 다음으로
      // 읽을 수 있는 정수가 있는 동안에 반복문의 내용을 실행합니다.
      // 이는 입력 스트림에서 정수를 한 번에 하나씩 읽어와 처리할 때 유용한 패턴입니다.
      // 반복문 내부에서 sc.nextInt()를 통해 정수를 읽을 수 있습니다.

      int a = sc.nextInt();
      int b = sc.nextInt();
      System.out.println(a + b);
    }
    sc.close();
  }
}