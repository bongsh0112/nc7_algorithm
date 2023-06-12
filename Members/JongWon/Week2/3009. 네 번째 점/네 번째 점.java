import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      Map<Integer, Integer> x = new HashMap<>();
      Map<Integer, Integer> y = new HashMap<>();

      for (int i = 0; i < 3; i++) {
        String[] num = br.readLine().split(" ");
        int tempX = Integer.parseInt(num[0]);
        int tempY = Integer.parseInt(num[1]);

        // x Setting
        if (x.containsKey(tempX))
          x.put(tempX, x.get(tempX) + 1);
        else
          x.put(tempX, 1);

        // y Setting
        if (y.containsKey(tempY))
          y.put(tempY, y.get(tempY) + 1);
        else
          y.put(tempY, 1);
      }

      StringBuffer sb = new StringBuffer();
      for (Integer key : x.keySet())
        if (x.get(key) != 2)
          sb.append(key + " ");

      for (Integer key : y.keySet())
        if (y.get(key) != 2)
          sb.append(key);

      System.out.println(sb.toString());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
