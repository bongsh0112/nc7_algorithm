package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1546 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        double[] scores = new double[n];
        String[] str = bf.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            scores[i] = Double.parseDouble(str[i]);
        }

        double sum = 0;
        double max = 0;

        for(int i = 0; i < n; i++) {
            if(scores[i] > max) {
                max = scores[i];
            }
        }

        for(int i = 0; i < n; i++) {
            scores[i] = (scores[i] / max) * 100;
            sum += scores[i];
        }

        System.out.printf("%.2f", sum / n);
    }
}
