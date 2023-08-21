package dontdothat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//예를 들어 6개의 포도주 잔이 있고, 각각의 잔에 순서대로 6, 10, 13, 9, 8, 1 만큼의 포도주가 들어 있을 때,
// 첫 번째, 두 번째, 네 번째, 다섯 번째 포도주 잔을 선택하면 총 포도주 양이 33으로 최대로 마실 수 있다.

//https://velog.io/@yanghl98/백준-2156-포도주-시식

public class BOJ_2156_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] liquid = new int[n];
        for (int i = 0; i < n; i++) {
            liquid[i] = Integer.parseInt(br.readLine());
        }

        int[] DP = new int[n];
        DP[0] = liquid[0];

        for (int i = 1; i < n; i++) {
            if(i==1){
                DP[1] = liquid[0] + liquid[1];
                continue;
            }
            if(i==2){
                DP[2] = Math.max(DP[1], Math.max(liquid[0]+liquid[2], liquid[1]+liquid[2]));
                continue;
            }
            DP[i] = Math.max(DP[i - 1], Math.max(DP[i - 2] + liquid[i], DP[i - 3] + liquid[i-1] + liquid[i]));
        }

        System.out.println(DP[n-1]);
    }
}


// i=2?

//  0   1   2
//  o   o   x => DP[i-1]
//  o   x   o => DP[i-2] + liquid[i]
//  x   o   o => DP[i-3] + liquid[i-1] + liquid[i]