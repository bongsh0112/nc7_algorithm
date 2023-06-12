import java.io.*;
import java.util.*;

public class BOJ_11653 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i =2; i < N; i++) {
            while(true) {
                if (N %i == 0) {
                    N = N /i;
                    System.out.println(i);
                } else {
                    break;
                }
            }
        }
        if (N >1) {
            System.out.println(N);
        }
    }
}


// 2부터 N의 제곱근까지 반복문을 돌면서 N을 i로 나눌 수 있는지 확인
// N을 i로 나눌 수 있다면, i는 N의 소인수이므로 출력하고, N을 i로 나눈 몫을 N에 다시 저장
// 이를 반복하여 N이 더 이상 i로 나눌 수 없을 때까지 진행.
//반복문이 종료된 후에도 N이 1보다 크다면, N 자체가 소수이므로 N을 출력
