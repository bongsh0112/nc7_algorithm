package Members.DongYoung.Week3;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
public class BOJ_2750 {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Integer [] arr = new Integer[N];
        for(int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        for(int a : arr) {
            System.out.println(a);
        }
        
    }
}
