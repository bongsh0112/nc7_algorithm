import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double[] grade = new double[Integer.parseInt(br.readLine())];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < grade.length; i++) {
           grade[i] = Double.parseDouble(st.nextToken());
        }

        double avr = 0;

        Arrays.sort(grade);

        for(int i = 0; i < grade.length; i++) {
            avr += (grade[i] / grade[grade.length - 1]) * 100;
        }
        System.out.println(avr / grade.length);



    }
}

