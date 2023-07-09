package Members.DongYoung.Week6;

import java.util.Scanner;

public class BOJ_2839 {
    public static void main(String[] args) {
        
        Scanner scanner  = new Scanner(System.in);

        int N = scanner.nextInt();

        int answer = 0;
        while(N > 0) {
            if (N % 5 == 0 ) {
                answer += N/5;
                break;
            }
            if (N % 5 == 3) {
                answer += N/5 + 1;
                break;
            }
            answer+=1;
            N = N - 3;

        }
        if (N >= 0) {
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }
    }
}
