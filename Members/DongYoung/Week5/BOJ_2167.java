package Members.DongYoung.Week5;

import java.util.Scanner;
import java.util.ArrayList;

public class BOJ_2167 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        int R = Integer.parseInt(str.split(" ")[0]);
        int C = Integer.parseInt(str.split(" ")[1]);

        int [][] arr = new int[R][C];
        for (int i = 0; i < R; i++) {
            String[] strList = scanner.nextLine().split(" ");
            for (int j = 0; j < C; j++) {
                arr[i][j] = Integer.parseInt(strList[j]);
            }
        }

        long ans = 0;
        int N = scanner.nextInt();
        ArrayList <Long> list = new ArrayList<>();
        scanner.nextLine();
        for (int i = 0; i < N; i++) {
            ans = 0;
            String[] strList = scanner.nextLine().split(" ");
            int x1 = Integer.parseInt(strList[0]);
            int y1 = Integer.parseInt(strList[1]);
            int x2 = Integer.parseInt(strList[2]);
            int y2 = Integer.parseInt(strList[3]);

            for (int a1 = x1; a1 <= x2; a1++) {
                for(int a2 = y1; a2 <= y2; a2++) {
                    ans += (long)arr[a1-1][a2-1];
                }
            }
            list.add(ans);
        }
        for(long a : list) {
            System.out.println(a);
        }
        scanner.close();
    }
}
