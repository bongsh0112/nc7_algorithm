    import java.io.*;
    import java.util.*;

    public class BOJ_11399 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);
            int sum =0 ; // 총합
            int add =0 ; // 더할 수

            for (int i=0; i< N; i++) {
                add += arr[i];
                sum += add;
            }
            System.out.print(sum);
        }
    }