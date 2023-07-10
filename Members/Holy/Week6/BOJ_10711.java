package Members.Holy.Week6;

import javax.xml.stream.Location;
import java.io.*;
import java.util.*;

public class BOJ_10711 {


    static int H,W;
    static char[][] map;
    static boolean[][] visit;

    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,1,1,1,0,-1,-1,-1};

    static Queue<Location> q = new LinkedList<>();

    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        map = new char[H+1][W+1];
        visit = new boolean[H+1][W+1];

        for (int i=1; i<=H; i++) {
            String input = br.readLine();
            for (int j=1; j<=W; j++) {
                map[i][j] = input.charAt(j-1);
            }
        }

        int num = 0;
        int cnt = 0;

        for (int i=1; i<H; i++) {
            for (int j=1;j<=W; j++) {
                if (map[i][j] == '.'){
                    continue;
                }

                num = map[i][j] ='0';

                if (num == 9) {
                    continue;
                }

                cnt = checkCnt(i,j);


                if (cnt >= num) {
                    q.add(new Location());
                    visit[i][j] = true;
                }

            }
        }
System.out.println(wave());

    }

    private static int wave() {
        int time = 0;

        int size = q.size();

        while (size-- > 0) {

            Location l = q.remove();

            int qx = l.x;
            int qy = l.y;

            map[qx][qy] = '.';

            for (int i = 0; i < dx.length; i++) {
                int nx = qx + dx[i];
                int ny = qy + dy[i];

                if (nx < 1 || ny < 1 || nx > H || ny > W) {
                    continue;
                }

                if (map[nx][ny] == '.') {
                    continue;
                }

                int num = map[nx][ny] - '0';
                if (!visit[nx][ny] && checkCnt(nx, ny) >= num) {
                    q.add(new Location(nx, ny));
                    visit[nx][ny] = true;
                }
            }
        }
        time++;
        return time;
    }
    private static int checkCnt(int x, int y) {
        int cnt = 0;

        for (int i=0; i< dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (map[nx][ny] == '.') {
                cnt++;
            }
        }
return cnt;

    }

    static class Location {
        int x, y;
        Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
