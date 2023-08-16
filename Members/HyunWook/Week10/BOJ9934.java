// 9934 - 완전 이진 트리

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int k, size;
	static int[] num;
	static ArrayList<Integer>[] tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		size = (int) (Math.pow(2, k) - 1);
		tree = new ArrayList[k + 1];
		num = new int[size + 1];

		for (int i = 0; i <= k; i++) {
			tree[i] = new ArrayList<>();
		}

		for (int i = 1; i <= size; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		search(1, 1, size);

		// 각 층에 빌딩 정보 BufferedWriter 저장
		for (int i = 1; i <= k; i++) {
			for (int j = 0; j < tree[i].size(); j++) {
				bw.write(tree[i].get(j) + " ");
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}

	// 중위 순회 특성 이용한 레벨에 맞는 빌딩 값들 저장 함수
	static void search(int depth, int start, int end) {
		int mid = (start + end) / 2; // Root
		tree[depth].add(num[mid]);
		// 단말 노드일 때
		if (depth == k) {
			return;
		}
		search(depth + 1, start, mid - 1); // Left
		search(depth + 1, mid + 1, end); // Right
	}
}