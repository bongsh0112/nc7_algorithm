package Members.DongYoung.Week9;

import java.util.Scanner;

public class BOJ_9655 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        if (N < 4) {
            System.out.println("SK");
        } else {
            if (N % 2 == 0) {
                System.out.println("CY");
            } else {
                System.out.println("SK");
            }
        }
        scanner.close(); 

    } 
}