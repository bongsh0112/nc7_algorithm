package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_4344 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(bf.readLine());

        for(int i = 0; i < n; i++) {

            String[] str = bf.readLine().split(" ");

            int numOfStudents = Integer.parseInt(str[0]);
            if (numOfStudents < 1 || numOfStudents > 1000)
                return;

            double sum = 0;
            for(int j = 1; j < str.length; j++) {
                sum += Double.parseDouble(str[j]);
            }
            double avg = sum / numOfStudents;

            int cnt = 0;
            for(int j = 1; j < str.length; j++) {
                if (avg < Double.parseDouble(str[j])) {
                    cnt += 1;
                }
            }

            double per = cnt / (double) numOfStudents * 100;
            sb.append(String.format("%.3f%%\n", per));

        }

        System.out.println(sb.toString());
    }

}
