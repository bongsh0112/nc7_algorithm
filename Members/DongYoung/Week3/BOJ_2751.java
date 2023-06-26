package Members.DongYoung.Week3;

import java.util.Scanner;
import java.util.Arrays;
import java.lang.StringBuffer;
public class BOJ_2751 {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Integer [] arr = new Integer[N];
        for(int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);

        StringBuffer sb = new StringBuffer();
        for(int a : arr) {
            sb.append(a);
            sb.append("\n");
        }
        System.out.println(sb.toString());
        
    }
}
