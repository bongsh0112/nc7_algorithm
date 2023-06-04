import java.io.*;
import java.util.*;

public class BOJ_10869 {

//사칙연산

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();

        int sum = A+B;
        int minus = A-B;
        int multiply = A*B;
        int divide1 = A/B;
        int divide2 = A%B;

        System.out.println(sum);
        System.out.println(minus);
        System.out.println(multiply);
        System.out.println(divide1);
        System.out.println(divide2);


    }
}