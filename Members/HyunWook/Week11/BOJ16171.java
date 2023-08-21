// 16171 - 나는 친구가 적다(Small)

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String S = br.readLine();
		String K = br.readLine();

		int result = findKeyWord(S, K);
		bw.write(result + "\n");

		br.close();
		bw.close();
	}

	public static String removeNumbers(String s) {
		return s.replaceAll("[0-9]", "");
	}

	public static int findKeyWord(String s, String keyword) {
		s = removeNumbers(s);

		if (keyword.length() > s.length()) {
			return 0;
		}
		for (int i = 0; i <= s.length() - keyword.length(); i++) {
			if (s.substring(i, i + keyword.length()).equals(keyword)) {
				return 1;
			}
		}
		return 0;
	}
}