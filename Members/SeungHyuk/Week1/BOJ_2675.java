import java.io.*;

public class BOJ_2675 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int tc = Integer.parseInt(br.readLine());

    for (int i = 0; i < tc; i++) {
      String[] str = br.readLine().split(" ");
      int n = Integer.parseInt(str[0]);

      for (int j = 0; j < str[1].length(); j++) {
        for (int k = 0; k < n; k++) {
          bw.write(str[1].charAt(j));
        }
      }
      bw.write('\n');
    }
    
    br.close();
    bw.flush();
    bw.close();
  }
}
