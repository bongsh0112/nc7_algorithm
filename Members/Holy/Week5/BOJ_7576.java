import java.io.*;
import java.util.*;

public class BOJ_7576 {
    static boolean[][] check;
    static int[][] tomato;
    static int[][] distance;
    static int M,N;
    static int count;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {-0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 가로 크기
        N = Integer.parseInt(st.nextToken()); // 세로 크기

        distance = new int[N][M];
        tomato = new int[N][M];

        for (int i=1; i<N; i++) {
            String A = br.readLine();
            for (int j = 1; j<M; j++) {
                tomato[i][j] = A.charAt(j);
            }
        }

        bfs(M,N);

        // Find maximum distance
        int maxDistance = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (distance[i][j] != 999999 && distance[i][j] > maxDistance) {
                    maxDistance = distance[i][j];
                }
            }
        }
        System.out.println(maxDistance);

        br.close();
    }

    private static int bfs() {
       Queue<int[]> q = new LinkedList<>();


        while (!q.isEmpty()) {
            int[] t = q.poll();
            int x = t[0];
            int y = t[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (tomato[nx][ny] == 0) {
                    tomato[nx][ny] = tomato[x][y] + 1;
                    q.add(new int[]{nx, ny});
                }
            }
        }

        int max = Integer.MIN_VALUE;
        if (checkZero()) {
            return -1;
        } else {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (max < tomato[i][j]) {
                        max = tomato[i][j];
                    }
                }
            }

            return max - 1;
        }


    }

    private static boolean checkZero() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tomato[i][j] == 0)
                    return true;
            }
        }
        return false;
    }
}
