import java.io.*;
import java.util.*;

public class BOJ_4344 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;

            int[] arr;
            int sum, count;
            int G = Integer.parseInt(br.readLine());
            for (int i = 0; i < G; i++) {
                sum = 0;
                count = 0;
                st = new StringTokenizer(br.readLine());
                int N = Integer.parseInt(st.nextToken());
                arr = new int[N];
                for (int j = 0; j < N; j++) { //배열 저장
                    arr[j] = Integer.parseInt(st.nextToken());
                    sum += arr[j];
                }
                for (int j = 0; j < N; j++) {
                    if ((float) sum / N < arr[j]) //TYPE CASTING
                        count++;
                }
                System.out.printf("%.3f%%\n", ((float) count / N) * 100);
            }
        }
}

