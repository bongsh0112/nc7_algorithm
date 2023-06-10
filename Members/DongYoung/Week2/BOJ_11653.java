import java.util.Scanner;

public class BOJ_11653 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());

        if (N == 1) {
            return;
        }
        boolean isDecimal = false;
        loop :while(!isDecimal) {
            for(int i = 2; i *i <= N; i++) {
                if(N % i == 0) {
                    System.out.println(i);
                    N = N / i;
                    continue loop;
                }
            }
            isDecimal = true;
        }
        System.out.println(N);
    } 
}
