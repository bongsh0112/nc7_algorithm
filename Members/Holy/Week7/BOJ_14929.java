import java.io.*;
import java.util.*;
public class BOJ_14929 {
    //https://coder-in-war.tistory.com/512
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];
        int[] sum = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for ( int i = 1; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i-1] + arr[i];
        }

        long ans =0;
        for (int i=1; i<n; i++) {
            int v = sum[n] - sum[i];
            ans += v *arr [i];
        }
        System.out.println(ans);
    }
}
