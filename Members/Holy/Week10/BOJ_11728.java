package dontdothat;

//https://turtle8760.tistory.com/95

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();


        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        int[] B = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        int p1 = 0, p2 = 0;

        while (p1 < N && p2 < M) {
            if (A[p1] <= B[p2]) {
                sb.append(A[p1++] + " ");
            } else {
                sb.append(B[p2++] + " ");
            }
        }


        if (p1 == N) {
            for (int i=p2; i< M; i++) {
                sb.append(B[i] + " ");
            }
        }
        if (p2 == M) {
            for (int i=p1; i<N; i++) {
                sb.append(A[i] + " ");
            }
        }

        System.out.println(sb);

        /*
        int[] result = new int[N + M];
        System.arraycopy(A, 0, result, 0, N);
        System.arraycopy(B, 0, result, N, M);

        Arrays.sort(result);

        for (int num : result) {
            System.out.print(num + " ");
        }

         */
    }
}
