package Members.DongYoung.Week9;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;

public class BOJ_7568 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<int[]> list = new ArrayList<>();
        ArrayList<int[]> list2 = new ArrayList<>();
        HashMap<int [], Integer> rankMap = new HashMap<>();
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            list.add(new int[] {a,b}); 
            list2.add(new int[] {a,b}); 
        }
        scanner.nextLine();



        StringBuffer sb = new StringBuffer("");
        for (int i = 0; i < list.size(); i++) {
            int rank = 1;
            for (int j = 0; j < list.size(); j++) {
                int [] arr1 = list.get(i);
                int [] arr2 = list.get(j);
                if (arr1[0] < arr2[0] && arr1[1] < arr2[1]) { // 덩치 차이가 남
                    rank++; 
                } 
            }
            sb.append(rank + " ");   
        }
        System.out.println(sb.toString());
    }
}