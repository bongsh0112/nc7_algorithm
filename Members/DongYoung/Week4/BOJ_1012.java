package Members.DongYoung.Week4;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

import java.lang.StringBuffer;

public class BOJ_1012 {

    static int[][] adjArr;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N0 = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < N0; i++) {
            String a =br.readLine();
            int N = Integer.parseInt(a.split(" ")[0]);
            int M = Integer.parseInt(a.split(" ")[1]);
            int len = Integer.parseInt(a.split(" ")[2]); 
            adjArr = new int[N+1][M+1];

            int cnt = 0;
            for(int j = 0; j < len; j++) {
                String str = br.readLine();
                int y1 = Integer.parseInt(str.split(" ")[0]);
                int x1 = Integer.parseInt(str.split(" ")[1]);
                adjArr[y1][x1] = 1;
            }

            for(int a1 = 0; a1 < adjArr.length; a1++) {
                for(int a2 = 0; a2 < adjArr[0].length; a2++) {
                    if(bfs(a1,a2)) {
                        cnt++;
                    }
                }
            }
            sb.append(cnt + "\n");
        }
        System.out.println(sb.toString());
    } 

    static boolean bfs(int y1, int x1) {
        if(adjArr[y1][x1] == 0) {
            return false;
        }
        int XMax = adjArr[0].length;
        int YMax = adjArr.length;
        Queue<xy> queue = new LinkedList<>();
        queue.offer(new xy(y1,x1));
        while(!queue.isEmpty()) {
            xy now = queue.poll();
            for(int i = 0; i < 4; i++) {
                int x2 = now.x + dx[i];
                int y2 = now.y + dy[i];
                if( x2 >=0 && x2 < XMax && y2 >=0 && y2 < YMax) {
                    if(adjArr[y2][x2] == 1) {
                        queue.offer(new xy(y2,x2));
                        adjArr[y2][x2] = 0;
                    }
                }
            }
            
        }
        return true;
    }
    static public class xy {
        int x;
        int y;
        public xy(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }
    
}
