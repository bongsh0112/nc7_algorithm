import java.io.*;
import java.util.*;
// 회사에 있는 사람
public class Main {
public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringBuffer sb = new StringBuffer();
	int n = Integer.parseInt(br.readLine());

	HashMap<String, String> map = new HashMap<String, String>();

	for (int i = 0; i < n; i++) {
		String[] str = br.readLine().split(" ");
		String name = str[0];
		String state = str[1];
		if (map.containsKey(name)) {
		map.remove(name);
		} else {
		map.put(name, state);
		}
	}

	ArrayList<String> list = new ArrayList<String>(map.keySet());
	Collections.sort(list, Collections.reverseOrder());
	for (String li : list) {
		sb.append(li + "\n");
	}
		System.out.println(sb);
	}
}
