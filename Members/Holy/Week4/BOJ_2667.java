import java.io.*;
import java.util.*;

public class BOJ_2667 {
    static boolean[][] check;
    static int[][] map;
    static int count = 0;
    static int[] x = {0,0,1,-1}; // x 방향 좌표
    static int[] y = {0,0,1,-1}; // y 방향 좌표

    static Queue<Integer> queue = new LinkedList<>();


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        check = new boolean[N][N];

        for (int i=0; i< N; i++) {
            String find = br.readLine();
            if (find.equals("1")){

            }

        }




    }



    public static void bfs(int start){

    }
}
