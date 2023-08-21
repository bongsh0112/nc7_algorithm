package dontdothat;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1789 {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 정수 S를 입력받음
        long S = Long.parseLong(br.readLine());

        // 입력 받은 S를 처리하고 문제를 해결하는 로직 작성
        long sum = 0; // 순차적으로 더해지는 합
        long N = 1;   // 더해지는 수


        while (sum + N <= S) {
            sum += N;
            N++;
        }

        // 결과 출력
        System.out.println(N - 1);

        br.close();
    }
}
