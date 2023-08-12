package dontdothat;

import java.util.*;
import java.io.*;

//https://zoonvivor.tistory.com/144
//      10 1 10 2 1
//      U = +2 D = -1
//  1   3   5   7   9   11  10
//    U   U   U   U   U    D


public class BOJ_5014 {

    static int  F, S, G, U, D;
    static int visited[];

    public static void main(String[] args) throws Exception {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String arr = bf.readLine();
        StringTokenizer st = new StringTokenizer(arr);
        F = Integer.parseInt(st.nextToken()); // 고층 버튼
        S = Integer.parseInt(st.nextToken()); // 현 위치
        G = Integer.parseInt(st.nextToken()); // 이동 층수
        U = Integer.parseInt(st.nextToken()); // 상승 층
        D = Integer.parseInt(st.nextToken()); // 하락 층
        visited = new int[F +1]; // 시작이 1층이기에  +1

        System.out.println(bfs(F, S, G, U, D,visited));

    }

    static String bfs(int F, int S, int G, int U, int D, int[] visited) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(S);
        BOJ_5014.visited[S] = 1;

        while (!q.isEmpty()) {
            int x = q.poll();

            if (x == G) { // 현재 위치에서 이동하기
                System.out.println(BOJ_5014.visited[x] -1); // 맨 처음 버튼 누른것 뻄
            }
            if (x + U < F && BOJ_5014.visited[x + U] ==0) { // 상승한 층수가 최고층보다 낮고 방문한 적 없으면
                BOJ_5014.visited[x + U] = BOJ_5014.visited[x] +1; // 방문을 남기고
                q.add(x + U); // stack 저장
            }
            if (x -D > 0 && BOJ_5014.visited[x -D] == 0)  {// 하락 층수가 음수가 아니고 방문한적 없으면
                BOJ_5014.visited[x -D] = BOJ_5014.visited[x] +1;  // 방문 남기고
                q.add(x -D); // stack 저장
                }

            }

        return "use the stairs";
    }
}



