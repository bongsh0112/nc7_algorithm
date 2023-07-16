package Members.DongYoung.Week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;

public class BOJ_1026 { 
    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        String [] split = br.readLine().split(" ");
        int [] arr1 = new int [N];
        int [] arr2 = new int [N];
        for (int i = 0; i < N; i++) {
            arr1[i] = Integer.parseInt(split[i]);
        }
        split = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr2[i] = Integer.parseInt(split[i]);
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans += arr1[i] * arr2[N-i-1];
        }
        System.out.println(ans);
    }
}