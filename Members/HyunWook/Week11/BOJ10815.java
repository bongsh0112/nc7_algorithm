// 10815 - 숫자 카드

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine()); // 상근이가 가지고 있는 숫자 카드의 개수

		HashSet<Integer> cards = new HashSet<>();
		String[] cardInput = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			cards.add(Integer.parseInt(cardInput[i])); // 숫자 카드들을 저장
		}

		int m = Integer.parseInt(br.readLine()); // 판단할 수의 개수
		String[] queryInput = br.readLine().split(" ");
		for (int i = 0; i < m; i++) {
			int query = Integer.parseInt(queryInput[i]);
			if (cards.contains(query)) {
				System.out.print("1 ");
			} else {
				System.out.print("0 ");
			}
		}

		br.close();
	}
}
