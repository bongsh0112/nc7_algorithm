import java.util.*; // java.util 에서 패키지의 모든 클래스를 가져오는 것
import java.io.*;

public class Main {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int arr[] = new int[10]; // arr 배열은 입력받은 정수의 나머지 값을 저장하는 용도로 사용되고,
    int count = 0; // count는 서로 다른 나머지 값의 개수를 저장합니다.

    for (int i = 0; i < 10; i++) {
      arr[i] = sc.nextInt() % 42; // 나머지 값 계싼
    }
    for (int i = 0; i < 10; i++) {
      int tmp = 0;
      for (int j = i + 1; j < 10; j++) {
        if (arr[i] == arr[j]) {
          tmp++; // 만약 같은 값을 가진 원소를 발견하면 tmp 변수를 증가시킵니다.
        }
      }
      if (tmp == 0) { // 내부 for 반복문이 종료되면 tmp 변수의 값이 0인 경우는 중복되는 나머지 값이 없는 경우입니다.
        count++; // 이 경우 count 변수를 증가시킵니다.
      }
    }
    sc.close();
    System.out.println(count);
  }
}