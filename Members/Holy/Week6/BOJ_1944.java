package Members.Holy.Week6;

import java.io.*;
import java.util.*;


public class BOJ_1944 {
    static ArrayList<Node> list;
    static int n, m;
    static char[][] board;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static PriorityQueue<Mst_Node> pq;
    static int[] parent;

    public static void main(String[] args) throws IOException {

        //입력
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String str = bf.readLine();
        StringTokenizer st = new StringTokenizer(str);
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new char[n][n];
        list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            str = bf.readLine();
            for(int j = 0; j < n; j++) {
                char c = str.charAt(j);
                board[i][j] = c;
                if(c == 'S' || c == 'K') list.add(new Node(i, j, 0));
            }
        }
        //입력 끝

        pq = new PriorityQueue<Mst_Node>();
        for(int i = 0; i < m + 1; i++) {
            bfs(i);
        }
        System.out.println(kruskal());
    }

    public static int kruskal() {
        parent = new int[m + 1];
        for(int i = 0; i < m + 1; i++) {
            parent[i] = i;
        }

        int cost = 0;
        int edge_count = 0;
        while(!pq.isEmpty()) {
            Mst_Node current = pq.poll();

            int p1 = find(current.s);
            int p2 = find(current.e);

            if(p1 != p2) {
                union(p1, p2);
                cost += current.cost;
                edge_count++;
            }
        }
        if(edge_count != m) return -1; //모두 연결되지 않으면 안됨.
        return cost;
    }

    public static void union(int p1, int p2) {
        parent[p1] = p2;
    }

    public static int find(int node) {
        if(parent[node] == node) return node;
        else return parent[node] = find(parent[node]);
    }

    public static void bfs(int num) {
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        q.offer(list.get(num));
        visited[list.get(num).x][list.get(num).y] = true;

        while(!q.isEmpty()) {
            Node current = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if(board[nx][ny] == '1' || visited[nx][ny]) continue;
                visited[nx][ny] = true;

                if(board[nx][ny] == 'S' || board[nx][ny] == 'K') {
                    for(int j = 0; j < m + 1; j++) {
                        if(list.get(j).x == nx && list.get(j).y == ny) {
                            pq.offer(new Mst_Node(num, j, current.count + 1));
                        }
                    }
                }
                q.offer(new Node(nx, ny, current.count + 1));
            }
        }
    }

    public static class Mst_Node implements Comparable<Mst_Node> {
        int s, e, cost;

        public Mst_Node(int s, int e, int cost) {
            this.s = s;
            this.e = e;
            this.cost = cost;
        }

        @Override
        public int compareTo(Mst_Node n) {
            return this.cost - n.cost;
        }
    }


//    compareTo 메서드는 이 코드에서 필요한 이유는 Mst_Node 클래스가 Comparable 인터페이스를 구현하기 때문입니다.
//    compareTo 메서드는 Mst_Node 클래스의 객체들의 자연적인 순서를 정의하는 데 사용됩니다. 이 메서드는 두 개의 Mst_Node 객체를 비교하여 순서를 결정합니다.
//    코드에서 우선순위 큐 pq를 사용하여 최소 신장 트리(Minimum Spanning Tree)를 구성하는데, pq는 내부적으로 compareTo 메서드를 사용하여 요소들의 순서를 정렬합니다.
//    compareTo 메서드의 구현은 cost 값을 기준으로 오름차순으로 정렬하도록 되어 있습니다. 이를 통해 pq에서 최소 비용의 간선부터 선택되어 최소 신장 트리를 구성할 수 있습니다.

    public static class Node {
        int x, y, count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
