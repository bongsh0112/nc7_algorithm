package Members.DongYoung.Week6;

import java.util.Scanner;
import java.lang.Math;

public class BOJ_1749 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        scanner.nextLine();
        int [][] sum = new int [N+1][M+1];
        int maxNum = -200000000;
        for(int i = 1; i <= N; i++) {
            String [] splitStr = scanner.nextLine().split(" ");
            for(int j = 1; j <= M; j++) {
                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + Integer.parseInt(splitStr[j-1]);
            }
        }
        //완전탐색 시작

        for(int i1 = 1; i1 <=N; i1++) {
            for(int j1 = 1; j1 <= M; j1++) {
                for( int i = i1; i <= N; i++) {
                    for(int j = j1; j <= M; j++) {
                        maxNum = Math.max(maxNum,sum[i][j] - sum[i][j-j1] - sum[i-i1][j] + sum[i-i1][j-j1]);
                    }
                }
            }
        }
        System.out.println(maxNum);

        
        
    }
}
