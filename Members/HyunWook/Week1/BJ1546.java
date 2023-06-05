import java.util.*; // java.util 에서 패키지의 모든 클래스를 가져오는 것
import java.io.*;

public class Main {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt(); // 점수의 개수
    float[] record = new float[n]; // 길이가 n인 실수형 배열 record와 변수 max, avg를 선언합니다.
    float max = 0;
    float avg = 0;

    for (int i = 0; i < record.length; i++) { // record 배열을 순회하면서 점수를 입력받고,
      record[i] = sc.nextInt();
      if (record[i] > max) { // 동시에 최대값을 찾아 max 변수에 저장합니다
        max = record[i]; // 입력받은 점수가 max보다 큰 경우에만 max 변수를 갱신합니다.
      }
    }

    for (int j = 0; j < record.length; j++) { // 각 점수에 대한 상대적인 비율을 계산하여 avg 변수에 누적합니다
      avg += (record[j] / max * 100) / n; // 수를 최대값으로 나눈 비율에 100을 곱하고,
    } // 그 결과를 점수의 개수 n으로 나누어 평균을 계산합니다
    System.out.println(avg);
  }
}