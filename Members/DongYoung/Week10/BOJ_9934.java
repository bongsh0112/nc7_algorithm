package Members.DongYoung.Week10;

import java.util.Scanner;
import java.util.ArrayList;

public class BOJ_9934 {
    public static void main(String[]args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }
        scanner.nextLine();

        String [] split = scanner.nextLine().split(" ");
        for (int i = 0; i < split.length; i++) {
            int a = Integer.parseInt(split[i]);
            for (int j = N-1; j >= 0; j--) {
                if ((i+1) % (int)Math.pow(2,j) == 0) {
                    list.get(N-j-1).add(a);
                    break;
                }
            }
        }

        for (ArrayList<Integer> list2 : list) {
            for (int a : list2) {
                System.out.printf("%d ",a);
            }
            System.out.println();
        }
        
    }
}
