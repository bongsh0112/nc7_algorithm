package Members.DongYoung.Week6;

import java.util.Scanner;

public class BOJ_5585 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = 1000 - scanner.nextInt();

        int answer = 0;
        while(N>= 500) {
            N = N-500;
            answer++;
        }
         while(N>= 100) {
            N = N-100;
            answer++;
        }
         while(N>= 50) {
            N = N-50;
            answer++;
        }
         while(N>= 10) {
            N = N-10;
            answer++;
        }
         while(N>= 5) {
            N = N-5;
            answer++;
        }
         while(N>= 1) {
            N = N-1;
            answer++;
        }

        System.out.println(answer);

    }
}
