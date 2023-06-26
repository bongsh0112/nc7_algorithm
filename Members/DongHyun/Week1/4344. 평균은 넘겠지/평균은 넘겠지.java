import java.io.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        double avg = 0;
        int cnt = 0;
        for(int i = 0; i < tc; i++) { //tc 개수
            int n = sc.nextInt();
            int[] arr = new int[n];
            double sum =0;
            for(int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
                sum += arr[j];
            }
            avg = sum / n;
            for(int k = 0; k < n; k++) {
                if(arr[k] > avg){
                    cnt++;
                }
            }
            System.out.printf("%.3f%%\n", (double)cnt/n*100);
            cnt = 0;
        }
    }
}

