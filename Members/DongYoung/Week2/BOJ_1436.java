import java.util.Scanner;

public class BOJ_1436 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        scanner.nextLine();

        int num = 0;
        int count = 0;
        while(true) {
            num++;
            String a = String.valueOf(num);
            if(a.contains("666")) {
                count++;
            }
            if(count == N) {
                break;
            }
            
        }
        System.out.println(num);
        scanner.close();
    }
}
