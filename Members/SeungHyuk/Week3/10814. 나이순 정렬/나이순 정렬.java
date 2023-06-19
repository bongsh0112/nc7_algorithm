import java.io.*;
import java.util.*;

public class Main {
   public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer sb = new StringBuffer();
    int n = Integer.parseInt(br.readLine());

    String[][] arr = new String[n][2];
	   	 	
    for (int i =  0 ; i < n; i++) {
      String[] str = br.readLine().split(" ");
      arr[i][0] = str[0];
      arr[i][1] = str[1];
    }
  
    Arrays.sort(arr, new Comparator<String[]>() {
      @Override
      public int compare(String[] s1, String[] s2) {
        if (s1[0] == s2[0]) {
          return 1;
        } else {
          return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
        }
      }
    });

    for(int i = 0; i < n; i++) {
      sb.append(arr[i][0] + " " + arr[i][1] + "\n");
    }

    System.out.println(sb);
   }
}
