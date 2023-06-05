import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int hh = Integer.parseInt(st.nextToken());
        int mm = Integer.parseInt(st.nextToken());

        int time = Integer.parseInt(br.readLine());
        mm += time;
        
        while(mm >= 60){
            hh++;
            mm -= 60;
        }
        if(hh >= 24){
            hh -= 24;
        }
        bw.write(hh + " " + mm);
        
        br.close();
        bw.flush();
        bw.close();
    }
}
