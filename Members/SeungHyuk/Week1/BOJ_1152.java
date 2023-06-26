import java.io.*;

public class BOJ_1152 {
  public static void main (String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] str = br.readLine().trim().split(" ");
    int ret = str.length;

    if (str[0] == "") {
      ret = 0;
    }
    
    bw.write(ret + "\n");

    br.close();
    bw.flush();
    bw.close();
  }
}
