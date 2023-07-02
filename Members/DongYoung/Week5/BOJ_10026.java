package Members.DongYoung.Week5;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class BOJ_10026 {

    static boolean [][] visited1;
    static boolean [][] visited2;
    static int [] dx = {0,1,0,-1};
    static int [] dy = {-1,0,1,0};
    static int [][] adjArr;
    public static void main(String[]args) {


        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        adjArr = new int [N+1][N+1];
        visited1 = new boolean [N+1][N+1];
        visited2 = new boolean [N+1][N+1];
        for(int i = 1; i < N+1; i++) {
            String str = scanner.nextLine();
            for(int j = 1; j < N+1; j++) {
                adjArr[i][j] = str.charAt(j-1)==('R') ? 2 : str.charAt(j-1)==('G') ? 1 : 0;
            }
        }
        
        int cnt1 = 0;
        int cnt2 = 0;
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(bfs1(i,j)) {
                    cnt1++;
                }
                if(bfs2(i,j)) {
                    cnt2++;
                }
            }
        }
        System.out.println(cnt1);
        System.out.println(cnt2);

        
        
    }

    static boolean bfs1(int y, int x) {
        if (visited1[y][x]) {
            return false;
        }
        Node node = new Node(y,x,adjArr[y][x]);
        Queue <Node> queue = new LinkedList<>();
        queue.offer(node);
        visited1[y][x] = true;
        while(!queue.isEmpty()) {
            Node now = queue.poll();
            for(int i = 0; i < 4; i++) {
                int y1 = now.y + dy[i];
                int x1 = now.x + dx[i];
                if(x1 > 0 && x1 <adjArr.length && y1 > 0 && y1 <adjArr.length) {
                    if(!visited1[y1][x1] && adjArr[y1][x1] == now.color) {
                        visited1[y1][x1] = true;
                        queue.offer(new Node(y1,x1,now.color));
                    }
                }
            } 
        }
        return true;
        
    }
    static boolean bfs2(int y, int x) {
        boolean isBlue = adjArr[y][x] == 0;
        if (visited2[y][x]) {
            return false;
        }
        Node node = new Node(y,x,adjArr[y][x]);
        Queue <Node> queue = new LinkedList<>();
        queue.offer(node);
        visited2[y][x] = true;
        while(!queue.isEmpty()) {
            Node now = queue.poll();
            for(int i = 0; i < 4; i++) {
                int y1 = now.y + dy[i];
                int x1 = now.x + dx[i];
                if(x1 > 0 && x1 <adjArr.length && y1 > 0 && y1 <adjArr.length) {

                    if(!visited2[y1][x1] && ((adjArr[y1][x1] == 0) == isBlue)) {
                        visited2[y1][x1] = true;
                        queue.offer(new Node(y1,x1,now.color));
                    }
                }
            } 
        }
        return true;
        
    }
    static class Node {
        int x;
        int y;
        int color;
        public Node(int y, int x, int color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }
}
