import java.io.*;
import java.util.*;

public class BOJ_2667 {
    static int[][] map;
    static boolean[][] visited;
    static int N;
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우 방향 벡터
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 지도의 크기
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        ArrayList<Integer> complexCountList = new ArrayList<>(); // 단지별 집의 수를 저장할 리스트

        // 모든 위치를 탐색하면서 아직 방문하지 않은 1인 경우에 대해 BFS 탐색 수행
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    int count = bfs(i, j);
                    complexCountList.add(count);
                }
            }
        }

        Collections.sort(complexCountList); // 오름차순 정렬

        // 결과 출력
        System.out.println(complexCountList.size());
        for (int count : complexCountList) {
            System.out.println(count);
        }
    }

    public static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        int count = 1; // 집의 수를 카운트하기 위한 변수

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currX = curr[0];
            int currY = curr[1];

            for (int i = 0; i < 4; i++) {
                int nx = currX + dx[i];
                int ny = currY + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (map[nx][ny] == 1 && !visited[nx][ny]) {
                        queue.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
