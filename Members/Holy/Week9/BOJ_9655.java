package dontdothat;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//5
//1 && 3
//
//상근이가 지는 경우를 false, 이기는 경우를 true로 표시하겠습니다.
//        N = 0                      false 입니다.
//        N = 1 돌을 1개 가져갈 수 있으므로 true 입니다.
//        N = 2일 때, 돌을 1개 가져갈 수 있습니다. 하지만, 창영이가 다음 턴에서 남은 돌을 1개 가져가므로 false 입니다.
//        N = 3일 때, 돌을 3개 가져갈 수 있으므로 true 입니다.
//        N = 4 일 때, 돌을 1개 또는 3개 가져가도 다음 턴에 창영이가 돌을 3개 또는 1개 가져가므로 false 입니다.
//        위 과정을 반복해보면 아시겠지만, N이 홀수일 때는 상근이가 이기고, N이 짝수일 때는 창영이가 이깁니다.

public class BOJ_9655 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[] dp = new boolean[1001]; // 가능한 경우의 수는 1001가지

        dp[1] = true;
        dp[2] = false;

        for(int i=3; i<=n; i++)
            dp[i] = dp[i-2]; // dp[3] = dp[1] | dp[4] = dr[2] OH!

        System.out.print(dp[n]? "SK" : "CY");
    }
}
