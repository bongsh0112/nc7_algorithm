package Members.DongYoung.Week10;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2579 {
    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        int [] arr = new int [M];
        int [][] maxNum = new int [M][2];
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        if (M == 1) {
            System.out.println(arr[0]);
            return;
        }else if (M == 2) {
            System.out.println(arr[0] + arr[1]);
            return;
        }
        maxNum[0][0] = arr[0];
        maxNum[0][1] = arr[0];
        maxNum[1][0] = arr[0] + arr[1];
        maxNum[1][1] = arr[1];
        for (int i = 2; i < M; i++) {
            maxNum[i][0] = maxNum[i-1][1] + arr[i];
            maxNum[i][1] = Math.max(maxNum[i-2][0] + arr[i], maxNum[i-2][1] + arr[i]);
        }
        System.out.println(Math.max(maxNum[M-1][0],maxNum[M-1][1]));
    }
}
