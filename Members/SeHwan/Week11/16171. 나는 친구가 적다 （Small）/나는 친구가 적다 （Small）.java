import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
  
  public static void main(String[] args) throws IOException {
    
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder stringBuilder = new StringBuilder();
    
    String S = bufferedReader.readLine();
    String K = bufferedReader.readLine();
    
    String[] str = S.split("[0-9]");
    for (String s : str) {
      stringBuilder.append(s);
    }
    S = stringBuilder.toString();
    
    if (S.contains(K)) {
      System.out.println(1);
    } else {
      System.out.println(0);
    }
    
  }
  
}