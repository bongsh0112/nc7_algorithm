import java.util.*; // java.util 에서 패키지의 모든 클래스를 가져오는 것
import java.io.*;

public class Main {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int[] student = new int[31]; // 학생들의 출석 상태를 저장

    for (int i = 1; i < 29; i++) { // 1부터 28까지의 인덱스에 대해 학생들의 출석 상태
      int successe = sc.nextInt(); // student 배열에 해당 출석 상태를 저장
      student[successe] = 1; // 출석 한 학생을 1로 저장 <=> 결석 한 학생은 0으로 저장
    }
    for (int i = 1; i < student.length; i++) { // student 배열에서 값이 1이 아닌 경우(결석한 학생)에 해당하는 인덱스를 출력합니다.
      if (student[i] != 1)
        System.out.println(i);
    }
    sc.close();
  }
}