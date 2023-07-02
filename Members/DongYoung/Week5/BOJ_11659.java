package Members.DongYoung.Week5;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class BOJ_11659 {

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String str = bf.readLine();
        int N = Integer.parseInt(str.split(" ")[0]);
        int M = Integer.parseInt(str.split(" ")[1]);

        str = bf.readLine();
        int [] arr = new int[N];
        int [] sum = new int[N];
        String[] strList = str.split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(strList[i]);
        }
        sum[0] = arr[0];
        for (int i = 1; i < N; i++) {
            sum[i] = sum[i-1] + arr[i];
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            strList = bf.readLine().split(" ");
            int S = Integer.parseInt(strList[0]);
            int E = Integer.parseInt(strList[1]);
            list.add(sum[E-1] - sum[S-1] + arr[S-1]) ;
            
        }

        for( int a : list) {
            System.out.println(a);
        }
    }

    

}
