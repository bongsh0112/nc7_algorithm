import java.io.*;
import java.util.*;

public class BOJ_2178 {
    static int[][] maze;
    static int[][] distance;
    static boolean[][] visited;
    static int N, M; // 미로의 크기

    // 상하좌우 방향 벡터
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new int[N][M];
        distance = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = input.charAt(j);
            }
        }

        bfs(0, 0); // 출발지(1, 1)에서 BFS 탐색 수행

        // 결과 출력 (도착지까지의 최소 이동 칸 수)
        System.out.println(distance[N-1][M-1]);

        br.close();
    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        distance[x][y] = 1;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currX = curr[0];
            int currY = curr[1];

            for (int i = 0; i < 4; i++) {
                int nx = currX + dx[i];
                int ny = currY + dy[i]  ;

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (maze[nx][ny] == 1 && !visited[nx][ny]) {
                        queue.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        distance[nx][ny] = distance[currX][currY] + 1;
                        // 현재 위치까지의 이동 거리에 1을 더한 값을 다음 위치까지의 이동 거리로 설정하는 것
                    }
                }
            }
        }
    }
}
