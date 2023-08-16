package Members.DongYoung.Week10;

import java.util.Scanner;

public class BOJ_10844 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        int answer = 0;
        int [][] arr= new int [N][10];
        for (int i = 0; i < N; i++) {
            if (i == 0) {
                for (int j = 1; j < 10; j++ ) {
                    arr[i][j] = 1;
                }
            } else {
                for (int j = 0; j < 10;j++) {
                    if (j == 0 ) {
                        arr[i][j] = arr[i-1][j+1] % 1000000000;
                    } else if (j == 9) {
                        arr[i][j] = arr[i-1][j-1]% 1000000000;
                    } else {
                        arr[i][j] = (arr[i-1][j+1] + arr[i-1][j-1])% 1000000000;
                    }
                }
            }
        }
        for (int i = 0; i < 10; i++) {
            answer = (answer + arr[N-1][i])%1000000000;
        }
        System.out.println(answer);
        scanner.close();
    }
}
