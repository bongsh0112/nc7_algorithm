
// 10814 나이순 정렬
import java.util.Scanner;
import java.util.ArrayList; // ArrayList 메서드 활용
import java.util.Arrays;
import java.util.Comparator;

public class Main {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt(); // 입력할 인원 수
    String[][] arr = new String[N][2]; // N 행 2 열로 선언합니다. 이 배열은 각 행에 나이와 이름을 저장할 예정

    for (int i = 0; i < N; i++) { // 반복문을 이용하여 N번 반복하면서, 각 행의 나이와 이름을 입력
      for (int j = 0; j < 2; j++) {
        arr[i][j] = sc.next();
      }
    }
    Arrays.sort(arr, new Comparator<String[]>() { // arr 배열을 정렬합니다.
      public int compare(String[] s1, String[] s2) { // 정렬 기준은 Comparator 인터페이스를 익명 클래스로 구현하여 지정
        return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
      }
    });

    for (int i = 0; i < N; i++) {
      System.out.println(arr[i][0] + " " + arr[i][1]);
    }
  }
}
// compare() 메서드
// compare 메서드에서는 두 문자열 s1과 s2의 길이를 비교합니다.
// 길이가 같을 경우에는 s1.compareTo(s2)를 통해 사전 순으로 비교합니다.
// 길이가 다를 경우에는 길이의 차이를 반환하여 정렬합니다.

// Comparator<>
// Comparator를 사용하면 정렬, 검색, 우선순위 큐 등 다양한 데이터 구조에서 원하는 정렬 순서를 지정할 수 있습니다.
// Comparator는 compare 메서드를 구현해야 하며, 두 개의 객체를 비교하여 비교 결과를 반환해야 합니다.
// compare 메서드는 두 개의 인수 o1과 o2를 받으며, 비교 결과에 따라 음수, 양수, 또는 0을 반환합니다. 반환 값의 의미는
// 다음과 같습니다:

// 예시 코드)
// public interface Comparator<T> {
// int compare(T o1, T o2);
// boolean equals(Object obj);
// }

// 음수: o1이 o2보다 작음을 나타냅니다.
// 양수: o1이 o2보다 큼을 나타냅니다.
// 0: o1과 o2가 같음을 나타냅니다.
// Comparator 인터페이스의 compare 메서드를 구현하여 객체 비교 기준을 정의할 수 있습니다