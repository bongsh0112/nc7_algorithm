package dontdothat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//예를 들어 6개의 포도주 잔이 있고, 각각의 잔에 순서대로 6, 10, 13, 9, 8, 1 만큼의 포도주가 들어 있을 때,
// 첫 번째, 두 번째, 네 번째, 다섯 번째 포도주 잔을 선택하면 총 포도주 양이 33으로 최대로 마실 수 있다.


public class BOJ_2156 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //6

        int[] liquid = new int[N + 1];
        int[] DP = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            liquid[i] = Integer.parseInt(br.readLine());
        }

        DP[0] = 0;
        DP[1] = liquid[1];

        if (N > 1) {
            DP[2] = liquid[1] + liquid[2];
        }
        for (int i = 3; i <= N; i++) {
            DP[i] = Math.max(DP[i - 1],
                    Math.max(DP[i - 2] + liquid[i], DP[i - 3] + liquid[i - 1] + liquid[i])
            );
        }
        System.out.println(DP[N]);
    }
}


//         dp[1] = 6
//         dp[2] = 16
//         dp[3] = 23
//dp[3] = Math.max(dp[2], Math.max(arr[1] + arr[3], arr[2] + arr[3]));


//         dp[4] = 28
//         dp[5] = 31
//         dp[6] = 33


//
//    먼저 Top-Down 방식으로 풀 때 '반드시 마지막 계단을 밟는다'는 의미는 결국 마지막 계단에 대한 경우의 수들의 누적합 중 최댓값이다.
//    즉, 이전 계단이 마지막 계단보다 누적합이 컸다고 하더라도 마지막 계단을 밟을 수 없다면 그 값은 위 조건에 위배되어 정답이 아니다.
//    반면에 포도주 시식은 그런 조건이 없다.
//    즉, 마지막 와인잔이 선택 될 때가 최대 누적합일수도, 또는 그 이전 와인잔까지 선택이 최대 누적합일 수도 있다.
//
//        쉽게 생각하면 이렇다
//
//        10, 25, 30, 1 이 차례대로 있고, 2개를 초과하여 연속으로 뽑을 수 없을 때 마지막 숫자를 반드시 거쳐야 하는 경우와 그런 조건이 없는 경우 누적 합의 최댓값은 다음과 같이 달라진다.
//
//<마지막 숫자(1)를 반드시 거쳐야 하는경우>
//        10, 30, 1 → 누적합 : 41
//
//<위 조건이 없는 경우>
//        25, 30 → 누적합 : 55
//
//. 즉, N-1 번째 누적합과 큰 것 중 하나를 선택하여 dp를 갱신하는 것