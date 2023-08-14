package dontdothat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://st-lab.tistory.com/132
public class BOJ_2579 {
    static int addpoint;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] point = new int[N+1];
        int[] DP = new int[N +1];

        for (int i = 1; i <= N; i++) {
            point[i] = Integer.parseInt(br.readLine());
        }

        DP[1] = point[1]; // index = 0 은 시작점

        // 반복문 Bottom -UP 활용
        if (N >= 2) {
            DP[2] = point[1] + point[2]; //N이 1이 입력될수 이기 때문에 예외처리함
        }

        for (int i=3; i<=N; i++) {
            DP[i] = Math.max(DP[i-2],DP[i-3]+point[i-1]) + point[i];
        }

        System.out.println(DP[N]);

    }
}
