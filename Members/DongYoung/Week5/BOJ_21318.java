package Members.DongYoung.Week5;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BOJ_21318 {

    public static void main(String[]args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N];
        int[] sum = new int[N];
        String[] strList = bf.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(strList[i]);
        }
        sum[0] = 0;
        for(int i = 1; i < N; i++) {
            sum[i] = arr[i-1] <= arr[i] ? sum[i-1] : sum[i-1] + 1;
        }

        int Num = Integer.parseInt(bf.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < Num; i++) {
            strList = bf.readLine().split(" ");
            int S = Integer.parseInt(strList[0]);
            int E = Integer.parseInt(strList[1]);
            int cnt = 0;
            cnt = sum[E-1] -sum[S-1];
            list.add(cnt);

        }
        for(int a : list) {
            System.out.println(a);
        }
        bf.close();
    }
    
    

}
