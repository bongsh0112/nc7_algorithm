package Members.DongYoung.Week7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class BOJ_11399 {
    public static void main(String[]args)throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        String[] splitStr = bf.readLine().split(" ");
        int arr [] = new int [N];
        for (int i  = 0; i < N; i++) {
            arr[i] = Integer.parseInt(splitStr[i]);
        }
        Arrays.sort(arr);
        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans += arr[i] * (N-i);
        }
        System.out.println(ans);
    }
}
