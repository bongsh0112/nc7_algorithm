package Algo_study;

//DFS는 스택, 재귀 BFS는 큐를 활용

import java.io.*;
import java.util.*;


//그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.
public class BOJ_1260 {

    static int node, line, start;
    static boolean[] check;
    static int[][] arr;

    static StringBuilder sb = new StringBuilder();;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        node = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());


        arr = new int[node + 1][node + 1];
        check = new boolean[node + 1];
// 주어진 정점의 개수(n)에 1을 더해주는 것
// 정점 번호가 1부터 시작하기 때문

        for (int i = 0; i < line; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());

            arr[a][b] = arr[b][a] = 1; // 정점 a와 b를 양방향으로 연결하여 그래프에 간선을 추가하는 것을 의미
        }

        dfs(start);
        sb.append("\n");

        check = new boolean[node +1];
        bfs(start);
        System.out.println(sb);


    }

    public static void dfs(int start) {
        check[start] = true;
        sb.append(start + " ");

        for (int i = 0; i <= node; i++) {
            if (arr[start][i] == 1 && !check[i]) { // !check[i]는 정점 i가 아직 방문되지 않았음을 나타내는 조건입니다. check[i] 값이 false이면 정점 i가 방문되지 않은 상태
                dfs(i);
            }
        }

    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        check[start] = true;
        queue.add(start);
        while (!queue.isEmpty()) {
            int x = queue.poll();
            sb.append(x + " ");

            for(int i=1; i <= node; i++) {
                if (arr[start][i] == 1 && !check[i]) {
                    queue.add(i);
                    check[i] = true;
                }
            }
        }
    }
}
//    BFS 코드에서 큐에서 정점을 꺼낼 때 queue.poll()을 사용하면, 큐의 가장 앞에 있는 요소가 반환됩니다.
//        따라서 주어진 출력 예제인 5 5 3 5 4 5 2 1 2 3 4 3 1에 대해서 설명해보겠습니다.
//
//        초기 큐: [3] (시작 정점인 3을 큐에 추가)

//        queue.poll(): 큐에서 3을 꺼내고, 현재 정점인 3을 출력합니다.
//        출력: 3
//        현재 큐: []
//
//        3과 인접한 정점 1과 4를 큐에 추가합니다.
//        현재 큐: [1, 4]

//        queue.poll(): 큐에서 1을 꺼내고, 정점 1을 출력합니다.
//        출력: 1
//        현재 큐: [4]
//
//        queue.poll(): 큐에서 4를 꺼내고, 정점 4를 출력합니다.
//        출력: 4
//        현재 큐: []
//
//        4와 인접한 정점은 없으므로 큐에 추가할 정점이 없습니다.
//
//        따라서 BFS 탐색 결과는 3 1 4가 됩니다.

