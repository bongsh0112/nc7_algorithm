import java.util.Scanner;
import java.lang.Math;


public class BOJ_2231 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String str = scanner.nextLine();
        int length = str.length();
        int N = Integer.parseInt(str);

        int decomposition = 0;
        int result = 0;

        for(int i = N; i >= N - length * 9; i--) {
            decomposition = 0;
            int j = i;
            int length1 = (int)Math.log10(i);
            while(j >0) {
                decomposition += (j / (int)Math.pow(10,length1));
                j = j - (j / (int)Math.pow(10,length1)) * (int)Math.pow(10,length1);
                length1 --;               
            }
            if(i + decomposition == N) {
                result = i;
            }           
        }
        System.out.println(result);
       
    }
}
