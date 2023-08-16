package Members.DongYoung.Week10;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_11728 {
    public static void main(String[]args) throws Exception{
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

        String split[] = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);

        String [] arr1 = br.readLine().split(" ");
        String [] arr2 = br.readLine().split(" ");
        StringBuffer sb = new StringBuffer("");

        int pt1 = 0;
        int pt2 = 0;

        while (pt1 < N || pt2 < M) {
            if (pt1 >= N) {
                sb.append(arr2[pt2] + " ");
                pt2++;
            } else if (pt2 >= M) {
                sb.append(arr1[pt1] + " ");
                pt1++;
            } else {
                int a1 = Integer.parseInt(arr1[pt1]);
            int a2 = Integer.parseInt(arr2[pt2]);
            if (a1 < a2) {
                sb.append(a1+ " ");
                pt1++;
            } else if (a1 > a2) {
                sb.append(a2 + " ");
                pt2++;
            } else {
                sb.append(a2 + " " + a1 + " ");
                pt1++;
                pt2++;
            }
            }
            
        }
        System.out.println(sb.toString());
    }
}
