// 1967 - 트리의 지름

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int n, maxDistance, farthestNode;
	static ArrayList<ArrayList<Edge>> tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		// 노드의 개수에 따라 ArrayList를 생성하여 트리 구조를 표현
		tree = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			tree.add(new ArrayList<>());
		}
		// n-1개의 간선 정보를 입력받아 트리 구성
		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			// 양방향 간선으로 구성
			tree.get(parent).add(new Edge(child, weight));
			tree.get(child).add(new Edge(parent, weight));
		}
		maxDistance = 0;
		farthestNode = 0;

		// 임의의 노드에서 가장 먼 노드 찾기
		dfs(1, 0, new boolean[n + 1]);

		maxDistance = 0;
		// 가장 먼 노드에서 가장 먼 노드까지의 거리 찾기
		dfs(farthestNode, 0, new boolean[n + 1]);

		// 트리의 지름 출력
		System.out.println(maxDistance);
	}

	// 깊이 우선 탐색 (Depth First Search)
	static void dfs(int node, int distance, boolean[] visited) {
		visited[node] = true;

		// 현재까지의 거리가 최대 거리보다 크면 업데이트
		if (distance > maxDistance) {
			maxDistance = distance;
			farthestNode = node;
		}
		// 현재 노드와 연결된 모든 노드들에 대해 재귀적으로 호출
		for (Edge edge : tree.get(node)) {
			int nextNode = edge.to;
			int weight = edge.weight;
			if (!visited[nextNode]) {
				dfs(nextNode, distance + weight, visited);
			}
		}
	}

	// 트리의 간선을 나타내는 클래스
	static class Edge {
		int to; // 간선의 도착 노드
		int weight; // 간선의 가중치

		public Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}
}