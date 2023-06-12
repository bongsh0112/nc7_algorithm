import java.util.Scanner;

public class BOJ_10810 {
    public static void main(String[] args){
        int n, m, from, to, ballNo;
        n = m = from = to = ballNo = 0;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[] ans = new int[n];

        for(int i = 0; i < m; i++){
            from = sc.nextInt();
            to = sc.nextInt();
            ballNo = sc.nextInt();

            for(int j = from-1; j <= to-1; j++){
                ans[j] = ballNo;
            }
        }
        sc.close();
        for (int j = 0; j < n; j++){
            System.out.print(ans[j] + " ");
        }
    }
}
