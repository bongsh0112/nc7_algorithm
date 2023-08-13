package Members.DongYoung.Week10;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_9095 {
    public static void main(String[]args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer("");

        for (int i = 0; i < M; i++) {
            int a = Integer.parseInt(br.readLine());
            int [] arr = new int [a];
            for (int j = 0; j < a; j++) {
                if (j == 0) {
                    arr[j] = 1;
                } else if (j == 1) {
                    arr[j] = 2;
                } else if (j == 2) {
                    arr[j] =4;
                } else {
                    arr[j] = arr[j-1] + arr[j-2] + arr[j-3];
                }
            }
            sb.append(arr[a-1] + "\n");
            
        }
        System.out.println(sb.toString().substring(0,sb.toString().length()-1));
    }
}
