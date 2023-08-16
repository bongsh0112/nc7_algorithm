package Members.DongYoung.Week9;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1806 {
public static void main(String[]args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String [] split = br.readLine().split(" ");
    int N = Integer.parseInt(split[0]);
    int S = Integer.parseInt(split[1]);

    int start = 0;
    int end = 0;
    int sum = 0;
    int length = Integer.MAX_VALUE;
    split = br.readLine().split(" ");
    for (int i = 0; i < split.length; i++) {
        int num = Integer.parseInt(split[i]);
        sum += num;
        end++;
        
        if (sum >= S) {
            while (sum >=S && end != start) {
                length = Math.min(length,end-start);
                sum -= Integer.parseInt(split[start]);
                start++;              
            }
        }
        
    }
    System.out.println(length);
}

   
}
