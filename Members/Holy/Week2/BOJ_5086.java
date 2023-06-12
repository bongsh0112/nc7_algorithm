import java.io.*;
import java.util.*;


public class BOJ_5086 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        while ( true ){
            st = new StringTokenizer(br.readLine()," "); // 런타임 에러 유발 원인

            int first = Integer.parseInt(st.nextToken());
            int secound = Integer.parseInt(st.nextToken());

            if (first ==0 && secound == 0)
                break;
            if (secound% first == 0) {
                System.out.println("factor");
            } else if ( first % secound == 0) {
                System.out.println("multiple");
            } else {
                System.out.println("neither");
            }
        }
    }
}