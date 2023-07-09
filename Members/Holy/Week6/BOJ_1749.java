package Members.Holy.Week6;
//https://lackofwillpower.tistory.com/56

import java.io.*;
import java.util.*;

public class BOJ_1749 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        int[] arr = new int[M];
        int sum = 0;

        for (int i=1; i< N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= M; j++) {
                sum += arr[j];
            }
            if (sum)
        }

        System.out.println(sum);


    }
}
