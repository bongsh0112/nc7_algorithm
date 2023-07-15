import java.io.*;
import java.util.*;

public class BOJ_17086 {


//    아기상어끼리 안전거리를 구하는 줄 알았는데 다시 읽어보니 모든 칸에서 가장 가까운 안전거리를 구하는 것
//    아기상어가 있는 곳은 안전거리를 업데이트하지 않도록 해준다.
    static class Shark {
        int x, y;

        public Shark(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] check;
    static int[][] map;
    static int M, N;

    static Queue<Shark> q = new LinkedList<>();

    static int[] dX = { 0, 1, 1, 1, 0, -1, -1, -1 };
    static int[] dY = { 1, 1, 0, -1, -1, -1, 0, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        check = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    q.add(new Shark(j, i));
                }
            }
        }

        int answer = Integer.MIN_VALUE;

        Shark cur;
        while (!q.isEmpty()) {
            cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            for (int j = 0; j < 8; j++) { // 동서남북 + 대각선으로 방향으로 이동
                int y2 = y + dX[j]; // y2: 현재 위치에서 dX[j]만큼 이동한 y 좌표
                int X2 = x + dY[j]; // X2: 현재 위치에서 dY[j]만큼 이동한 x 좌표
                if (X2 < 0 || y2 < 0 || X2 >= M || y2 >= N)
                    continue; // 위치 이탈
                if (check[y2][X2] != 0 || map[y2][X2] == 1)
                    continue; // 이미 확인된 곳이면 pass
                check[y2][X2] = check[y][x] + 1; // 이동한 위치에 대해 현재까지의 최단 거리를 저장, 현재 위치의 최단 거리에 1을 더한 값을 저장
                if (check[y2][X2] > answer) // 이동한 위치의 최단 거리가 기존의 최댓값인 answer보다 크다면, answer 값을 업데이트
                    answer = check[y2][X2];
                q.add(new Shark(X2, y2));
            }
        }
        System.out.print(answer);
    }
}
