import java.io.*;
import java.util.*;


public class BOJ_10810 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //5
        int M = Integer.parseInt(st.nextToken()); //4
        int[] arr = new int[N];     //바구니 배열


        for (int i = 0; i < M; i++) {

            st = new StringTokenizer(br.readLine());

            int I = Integer.parseInt(st.nextToken()); //1
            int J = Integer.parseInt(st.nextToken()); //2
            int K = Integer.parseInt(st.nextToken()); //3

            for (int j = I - 1; j < J; j++) {
                arr[j] = K; // 바구니에 공 넣기
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " "); // 출력
        }
    }
}