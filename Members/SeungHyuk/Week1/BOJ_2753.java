import java.util.Scanner;

public class BOJ_2753 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int year, ans;
        year = ans = 0;
        year = sc.nextInt();
        sc.close();
        
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
            ans = 1;
            System.out.println(ans);
        }
        else {
            System.out.println(ans);
        }
    }
}
