// 14675 - 단절점과 단절선

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] list;
	static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 트리의 정점 개수 입력
		n = Integer.parseInt(br.readLine());

		// 정점별로 인접한 정점들을 저장하기 위한 ArrayList 초기화
		list = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			list[i] = new ArrayList<>();
		}

		// 간선 정보 입력 및 저장
		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list[s].add(e);
			list[e].add(s);
		}
		// 질의 개수 입력
		int q = Integer.parseInt(br.readLine());

		// 각 질의 처리
		for (int i = 0; i < q; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken()); // 질의 타입
			int k = Integer.parseInt(st.nextToken()); // 질의 대상

			if (t == 2) {
				System.out.println("yes"); // 질의 타입이 2인 경우 단절선이므로 항상 "yes"
			} else {
				int cnt = 0; // 인접한 정점의 개수를 세는 변수
				for (int x : list[k]) {
					cnt++;
				}
				if (cnt >= 2) {
					System.out.println("yes"); // 단절점일 때는 인접한 정점이 2개 이상이면 "yes"
				} else {
					System.out.println("no"); // 그렇지 않으면 "no"
				}
			}
		}
	}
}