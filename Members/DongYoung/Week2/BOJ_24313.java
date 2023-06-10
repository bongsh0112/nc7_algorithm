import java.util.Scanner;

public class BOJ_24313 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 함수 정리하면,  모든  (c - a1)n >= n0 * (c - a1) 에 대하여,   n(a1 - c) <= - a0  == > (c - a1)n >= a0 / 

        int a1;
        int a0;

        String []splitList = scanner.nextLine().split(" ");
        a1 = Integer.parseInt(splitList[0]);
        a0 = Integer.parseInt(splitList[1]);

        int c = scanner.nextInt();
        scanner.nextLine();

        int n0 = scanner.nextInt();
        scanner.nextLine();

        
        // 함수식을 보면 n이 1차 함수(선형) 이기때문에 한번 a0 보다 커지면 그 이후는 무조껀 a0 보다 커진다

        // 즉 n0일떄 해당 부등식을 만족하면 1, 만족하지 못하면 0이다

        if( a0 <= n0 * (c - a1) && c >= a1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        scanner.close();
    }
}
