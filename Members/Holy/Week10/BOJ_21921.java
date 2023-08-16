package dontdothat;


//https://nahwasa.com/entry/%EC%9E%90%EB%B0%94-%EB%B0%B1%EC%A4%80-21921-%EB%B8%94%EB%A1%9C%EA%B7%B8-java

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_21921 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    public static void main(String[] args) throws Exception {
        new BOJ_21921().solution();
    }

    public void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int sum = 0;
        for (int i = 0; i < x; i++) sum += arr[i];

        int max = sum;
        int maxCnt = 1;
        for (int i = x; i < n; i++) {
            sum += arr[i] - arr[i-x];
            if (max == sum) maxCnt++;
            else if (max < sum) {
                max = sum;
                maxCnt = 1;
            }
        }
        if (max == 0) {
            System.out.println("SAD");
            return;
        }
        System.out.println(max);
        System.out.println(maxCnt);
    }
}
