import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, data[][], sum[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        data = new int[N + 1][M + 1];
        sum = new int[N + 1][M + 1];

        for (int i = 1; i <= N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
                sum[i][j] = sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1] + data[i][j];
            }
        }

        int answer = Integer.MIN_VALUE;
        for (int rowS = 1; rowS <= N; rowS++) {
            for (int rowE = rowS; rowE <= N; rowE++) {
                for (int colS = 1; colS <= M; colS++) {
                    for (int colE = colS; colE <= M; colE++) {
                        answer = Math.max(answer, sum[rowE][colE] - sum[rowS - 1][colE] - sum[rowE][colS - 1] + sum[rowS - 1][colS - 1]);
                    }
                }
            }
        }
        System.out.println(answer);
    }
}