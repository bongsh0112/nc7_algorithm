import java.util.Scanner;
import java.util.Arrays;

public class BOJ_3052 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] arr = new int[10];
    int[] divArr = new int[10];
    int[] ret = new int[10];
    int cnt = 0;
    Arrays.fill(ret, -1);

    for(int i = 0; i < 10; i++) { // 입력
      arr[i] = sc.nextInt();
      divArr[i] = arr[i] % 42; // 배열 저장
    }
    sc.close();

    for(int i = 0; i < 10; i++) { // 배열 복사
      for(int j = 0; j < ret.length; j++) {
        if(divArr[i] == ret[j]) { // 중복된 값은 패스
          break;
        }
        if (j == ret.length-1) { // 중복되지 않았으면 추가
          ret[cnt++] = divArr[i];
        }
      }
    }
    System.out.println(cnt);
  }
}
