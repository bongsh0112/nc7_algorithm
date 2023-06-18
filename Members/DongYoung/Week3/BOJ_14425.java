package Members.DongYoung.Week3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
public class BOJ_14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine(); 
        int N = Integer.parseInt(str.split(" ")[0]);
        int M = Integer.parseInt(str.split(" ")[1]);
        String [] answerArr = new String[N];
        for(int i = 0; i < N; i++) {
            answerArr[i] = br.readLine();
        }

        int count = 0;
        loop1:for(int i = 0; i < M; i++) {
            String str1 = br.readLine();

            for(String aa : answerArr) {
                if( aa.equals(str1) ) {
                    count++;
                    continue loop1;
                }
            }
        }
        br.close();
        // bw.write(count);


        // bw.flush();
        // bw.close();

        System.out.println(count);
    }

}
