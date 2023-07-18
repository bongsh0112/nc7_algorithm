package Members.DongYoung.Week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14929 {
    public static void main(String[]args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int [] arr = new int [N+1];
        int [] sum = new int [N+1];
        long [] sn = new long [N+1];
        String[] split = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(split[i-1]);
            sum[i] = num + sum[i-1];
            sn[i] = sn[i-1] + sum[i-1] *num;
        }
        System.out.println(sn[N]);

    
    }
}
