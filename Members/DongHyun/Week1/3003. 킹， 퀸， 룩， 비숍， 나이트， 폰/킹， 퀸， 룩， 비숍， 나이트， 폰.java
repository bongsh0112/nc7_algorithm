import java.io.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int[] ch = new int[6];
        int per[] = {1, 1, 2, 2, 2, 8};
        for(int i = 0; i < 6; i++) {
//            int num = Integer.parseInt(br.readLine());
            int num = sc.nextInt();
            ch[i] = num;
        }
        for(int i = 0; i < 6; i++){
            System.out.print(per[i] - ch[i]);
            System.out.print(" ");
        }
    }
}

