
// 2738 행렬 덧셈
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();

    int A[][] = new int[N][M]; // A배열 생성 - N행과 M열
    int B[][] = new int[N][M]; // B배열 생성 - N행과 M열

    // A 2차 배열 값 입력
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        A[i][j] = sc.nextInt();
      }
    }
    // B 2차 배열 값 입력
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        B[i][j] = sc.nextInt();
      }
    }

    // A 배열과 B 배열의 같은 위치에 있는 요소들을 더한 후, 그 값을 출력합니다.
    // 덧셈 결과와 공백 문자를 함께 출력하여 값을 구분
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        System.out.print(A[i][j] + B[i][j] + " ");
        if (j == M - 1) // 구문은 현재 열이 해당 행의 마지막 열인지를 확인합니다.
                        // 만약 현재 열이 마지막 열이라면, 즉 열 인덱스가 M-1과 같다면, 개행 문자(\n)를 출력
          System.out.println();
      }
    }
  }
}