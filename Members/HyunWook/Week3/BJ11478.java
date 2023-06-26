
// 11478 서로 다른 부분 문자열 개수
import java.util.Scanner;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet; // HashSet은 중복을 허용하지 않는 자료구조로, 유일한 값만 저장
import java.util.Set;

public class Main {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    sc.close();

    // HashSet<String> list = new HashSet<>(); 구문은 문자열을 저장하기 위한 HashSet을 생성
    HashSet<String> list = new HashSet<>();

    // 이중 반복문을 사용하여 주어진 문자열에서 모든 부분 문자열을 추출합니다.
    // 첫 번째 반복문은 문자열의 시작 위치를 나타내며, 두 번째 반복문은 문자열의 끝 위치를 나타냅니다.
    // for (int i = 0; i < s.length(); i++) 구문은 문자열의 시작 위치를 0부터 문자열의 길이 - 1까지 반복
    // or (int j = i + 1; j <= s.length(); j++) 구문은 문자열의 끝 위치를 시작 위치 + 1부터 문자열의 길이까지
    // 반복
    for (int i = 0; i < s.length(); i++) {
      for (int j = i + 1; j <= s.length(); j++) {
        if (!list.contains(s.substring(i, j))) {
          list.add(s.substring(i, j));
        }
      }
    }
    // StringBuilder는 문자열을 효율적으로 처리하기 위한 클래스
    // StringBuilder sb = new StringBuilder(); 구문을 사용하여 StringBuilder 객체를 생성
    // sb.append(list.size() + "\n"); 구문은 HashSet에 저장된 부분 문자열의 개수를 StringBuilder에 추가
    // sb.toString()을 통해 StringBuilder 객체를 문자열로 변환하여 출력합니다.
    StringBuilder sb = new StringBuilder();
    sb.append(list.size() + "\n");
    System.out.println(sb);

  }
}
