package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2753 {

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String str = br.readLine();

            long year = Long.parseLong(str);

            if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
