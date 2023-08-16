package Members.DongYoung.Week9;

import java.util.Scanner;

public class BOJ_1783 {
    public static void main(String[]args) {
        Scanner scanner = new Scanner(System.in);

        int M = scanner.nextInt();
        int N = scanner.nextInt();
        int answer = 0;
        // M : 세로
        // N : 가로
        //세로 제약 : 세로가 한칸이면 최초 자리 유지 (1개)
        // 세로가 두칸이면, 3칸시 2개, 5칸시3개, 즉  (N-1) /2 + 1 개
        // 세로가 3칸이상이면 세로의 제약없음
        //가로 제약 
        //가로 1칸시 : 1번
        //가로 2칸시 : 2번
        //가로 3칸시 : 3번
        //가로 4칸시 : 4번
        //가로 5칸시 : 4번
        //가로 6칸시 : 4번
        //그이상은 늘어난 개수만큼 가능
        if (M == 1) {
            answer = 1;
        } else if (M == 2) {
            answer = Math.min((N-1) / 2 + 1,4) ;
        } else {
            if (N == 1) {
                answer = 1;
            } else if (N == 2 ) {
                answer = 2;
            }else if (N == 3){
                answer = 3;
            } else if (N == 4|| N == 5) {
                answer = 4;
            } else if (N == 6) {
                answer = 4;
            } else {
                answer = N -2;
            }
        }
        System.out.println(answer);
    }
}
