import java.io.*;
import java.util.*;


public class BOJ_2525 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        int totalmin = 60 * A + B;
        totalmin += C;

        int hour = (totalmin/60)%24;
        int min = totalmin%60;

        System.out.println(hour + " " + min);

    }
}