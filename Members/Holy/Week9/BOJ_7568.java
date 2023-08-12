package dontdothat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://st-lab.tistory.com/99
public class BOJ_7568 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2]; // 키 몸무게 받을 배


        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken()); // 몸무게
            arr[i][1] = Integer.parseInt(st.nextToken()); //  키
        }

        for (int i = 0; i < N; i++) {
            int rank = 1; // 1위 부터 시작!
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    continue; // 동일인은 동일 순위
                }

                if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
                    rank++; // 이전 값보다 키가 작으면 순위 증가!
                }

            }
            System.out.println(rank + " ");

        }


    }


}
