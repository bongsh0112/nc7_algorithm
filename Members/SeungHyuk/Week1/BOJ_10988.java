import java.io.*;

public class BOJ_10988 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String str = br.readLine();
    int ret = 1;

    for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
      if (str.charAt(i) != str.charAt(j)) {
        ret = 0;
        break;
      }
    }
    
    bw.write(ret + "\n");

    br.close();
    bw.flush();
    bw.close();
  }
}