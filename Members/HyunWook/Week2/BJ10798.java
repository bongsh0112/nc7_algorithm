
// 10798 세로읽기
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    char[][] chararr = new char[5][15]; // 5행 15열의 2차원 배열 만들기

    for (int i = 0; i < 5; i++) { // 5번의 반복문을 통해 5개의 문자열 입력받기
      String str = sc.next();
      for (int j = 0; j < str.length(); j++) {
        chararr[i][j] = str.charAt(j);
      }
    }
    for (int i = 0; i < 15; i++) { // 15번의 반복문을 통해 세로로 문자열 출력
      for (int j = 0; j < 5; j++) { // 2중 반복문을 통해서 배열을 세로 방향으로 전환
        if (chararr[j][i] == ' ' || chararr[j][i] == '\0') { // 만약 공백 문자나 널 문자('\0')라면,
          continue; // 다음 반복으로 넘어갑니다.
        }
        System.out.print(chararr[j][i]);
      }
    }
  }
}
