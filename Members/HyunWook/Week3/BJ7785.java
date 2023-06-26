
// 7785 회사에 있는 사람
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    HashMap<String, Boolean> hashMap = new HashMap<>();

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String name = st.nextToken();
      String type = st.nextToken();

      if (type.equals("enter")) {
        hashMap.put(name, true);
      } else if (type.equals("leave")) {
        hashMap.replace(name, false);
      }
    }
    // Object[] arrKey = hashMap.keySet().toArray() 구문은 HashMap의 키 값을 배열로 변환합니다.
    Object[] arrKey = hashMap.keySet().toArray(); 
    // Arrays.sort(arrKey, Collections.reverseOrder()) 구문은 배열을 내림차순으로 정렬합니다.
    Arrays.sort(arrKey, Collections.reverseOrder());

    for (Object s : arrKey) { // for (Object s : arrKey) 구문을 사용하여 정렬된 배열을 순회하면서 출력합니다.
      if (hashMap.get(s)) // hashMap.get(s)를 통해 해당 이름의 출입 상태를 확인하고, true인 경우에만 출력합니다.
        bw.write(s + "\n");
    }
    br.close();
    bw.close();
  }
}
