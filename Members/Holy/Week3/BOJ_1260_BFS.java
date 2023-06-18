package Algo_study;

//DFS는 스택, 재귀 BFS는 큐를 활용

import java.io.*;
import java.util.*;

public class BOJ_1260_BFS {

    static int node, line, start;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int node = Integer.parseInt(st.nextToken());
        int line = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());


        int[][] arr = new int[node+1][node+1];
        boolean[] check = new boolean[node+1];


        for (int i=0; i <line; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());

            arr[a][b] = arr[a][b] = 1;

        }

        public static void dnf(int start) {

        }

        public static void bnf(int start) {

        }


    }
}
