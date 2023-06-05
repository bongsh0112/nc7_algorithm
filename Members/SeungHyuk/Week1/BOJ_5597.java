import java.util.Scanner;

public class BOJ_5597 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[32];

        for (int i = 0; i < 28; i++) {
            arr[sc.nextInt()]++;
        }

        sc.close();

        for (int i = 1; i < 31; i++) {
            if (arr[i] == 0)
                System.out.println(i);
        }
    }
}