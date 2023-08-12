package dontdothat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1806 {

//    10 15 => 10개의 수열에서 15의 이상인 수는?
//5 1 3 5 10 7 4 9 2 8
//    1) 5+10 | 2) 10 + 7 |  3) 10 + 9 | ....
//    최소의 길이는?
//    2

    static  int[] arr ;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 10
        int S = Integer.parseInt(st.nextToken()); // 15


        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int len = Integer.MAX_VALUE; // 구하기 위한 최대
        int sum = 0;

        while(start <= end && end <= N) {
            if(sum < S) {
                sum += arr[end++];
            } else if(sum >= S) {
                len = Math.min(len, end-start); // 최솟값 구하ㅣ기 , end-start 길이!
                sum -= arr[start++];
            }
        }
        System.out.println(len==Integer.MAX_VALUE ? 0 : len);
    }
}