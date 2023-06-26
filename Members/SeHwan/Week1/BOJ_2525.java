package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2525 {

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] str = br.readLine().split(" ");
            int[] time = new int[2];
            for(int i = 0; i < str.length; i++) {
                time[i] = Integer.parseInt(str[i]);
            }
            int cookingTime = Integer.parseInt(br.readLine());

            if ((time[1] + cookingTime) / 60 > 0) {
                time[0] += (time[1] + cookingTime) / 60;
                time[1] = (time[1] + cookingTime) % 60;

                if (time[0] >= 24) { time[0] = time[0] - 24; }

            } else {
                if (time[0] >= 24) { time[0] = time[0] - 24; }
                time[1] += cookingTime;
            }

            int hour = time[0]; int minute = time[1];
            System.out.printf("%d %d", hour, minute);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
