import java.io.*;
import java.util.*;

public class BOJ_2167 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];

//배열 초기화
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int k = Integer.parseInt(br.readLine());
        for (int t = 0; t < k; t++) {
            st = new StringTokenizer(br.readLine());
            //입력으로부터 읽어들인 값을 배열 인덱스로 사용하기 위해 1을 빼주는 역할
            int i = Integer.parseInt(st.nextToken()) - 1; // 배열의 인덱스로 변환하는 것
            int j = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int sum = 0;

            // (i,j)부터 (x,y)까지 더하기
            for (int p = i; p <= x; p++) {
                for (int q = j; q <= y; q++) {
                    sum += arr[p][q];
                }
            }
            sb.append(sum + "\n");
        }
        System.out.print(sb);
    }
}