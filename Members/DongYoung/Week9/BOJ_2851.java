package Members.DongYoung.Week9;

import java.util.Scanner;

public class BOJ_2851 {

    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        int [] mushs = new int [10];
        for (int i = 0; i < mushs.length; i++) {
            mushs[i] = scanner.nextInt();
        }
        scanner.nextLine();
        int dif = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += mushs[i];
            int diff = Math.abs(100 - sum);
            if (diff > dif) {
                sum-= mushs[i];
                break;
            }
            dif = diff;
        }
        System.out.println(sum);
    }
 
}
