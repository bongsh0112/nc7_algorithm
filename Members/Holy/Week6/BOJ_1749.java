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


        int[][] data = new int[N + 1][M + 1];
        int[][] accumulateSum = new int[N + 1][M + 1];


        for (int i = 1; i <= N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
                accumulateSum[i][j] = accumulateSum[i][j - 1] + accumulateSum[i - 1][j] - accumulateSum[i - 1][j - 1] + data[i][j];
            }
        }

        int answer = Integer.MIN_VALUE;
        for (int rowS = 1; rowS <= N; rowS++) {
            for (int rowE = rowS; rowE <= N; rowE++) {
                for (int colS = 1; colS <= M; colS++) {
                    for (int colE = colS; colE <= M; colE++) {
                        answer = Math.max(answer, accumulateSum[rowE][colE] - accumulateSum[rowS - 1][colE] - accumulateSum[rowE][colS - 1] + accumulateSum[rowS - 1][colS - 1]);
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
