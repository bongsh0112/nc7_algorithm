package Members.DongYoung.Week9;

import java.util.Scanner;

public class BOJ_2875 {
    public static void main(String[]args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int K = scanner.nextInt();
        //팀당 남자 1 여자 2
        int answer = 0;
        while (M>=0 && N >= 0) {
            N = N-2;
            M = M-1;
            if (M+N < K || M <0 || N < 0) {
                break;
            }
            answer++;
        }
        System.out.println(answer);
        
    }
}
