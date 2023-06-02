import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        Scanner sc = new Scanner(System.in);
        boolean[] arr = new boolean[31];
        for(int i = 0; i < 28; i++) {
            int n = Integer.parseInt(br.readLine());
//            int n = sc.nextInt();
            arr[n] = true;
        };
        for(int i = 1; i <= 30; i++) {
            if(!arr[i]){
                System.out.println(i);
            }
        }
    }
}