
// 1181 단어정렬
import java.util.Scanner;
import java.util.ArrayList; // ArrayList 메서드 활용
import java.util.Arrays;
import java.util.Comparator;

public class Main {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    String arr[] = new String[N];
    sc.nextLine();

    for (int i = 0; i < N; i++) {
      arr[i] = sc.nextLine();
    }

    // 1.길이순으로, 2.사전순으로
    Arrays.sort(arr, new Comparator<String>() { // Arrays.sort 메서드를 사용하여 arr 배열을 정렬합니다.
      // 정렬 기준은 Comparator 인터페이스를 익명 클래스로 구현하여 지정
      @Override
      public int compare(String s1, String s2) {
        if (s1.length() == s2.length()) {
          return s1.compareTo(s2);
        } else {
          return s1.length() - s2.length();
        }
      }
    });

    // 중복제거
    // 정렬된 배열 arr에서 중복을 제거하고 출력합니다.
    // 첫 번째 단어를 먼저 출력하고, 그 다음부터는 이전 단어와 비교하여 중복된 경우는 출력하지 않습니다.
    System.out.println(arr[0]);
    for (int i = 1; i < N; i++) {
      if (arr[i].equals(arr[i - 1]))
        continue;
      System.out.println(arr[i]);
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