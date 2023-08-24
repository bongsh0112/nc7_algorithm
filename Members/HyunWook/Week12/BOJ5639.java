// 5639 - 이진 검색 트리

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node {
	int data;
	Node left, right;

	public Node(int data) {
		this.data = data;
		left = right = null;
	}
}

public class Main {
	static Node root;

	// 이진 트리에 노드를 삽입하는 메소드
	static Node insert(Node node, int data) {
		if (node == null) {
			return new Node(data); // 노드가 비어있으면 새로운 노드 생성
		}

		if (data < node.data) {
			node.left = insert(node.left, data); // 데이터가 현재 노드보다 작으면 왼쪽 서브트리에 삽입
		} else if (data > node.data) {
			node.right = insert(node.right, data); // 데이터가 현재 노드보다 크면 오른쪽 서브트리에 삽입
		}

		return node;
	}

	// 후위 순회 메소드
	static void postorder(Node node) {
		if (node == null) {
			return; // 노드가 비어있으면 리턴
		}

		postorder(node.left); // 왼쪽 서브트리 후위 순회
		postorder(node.right); // 오른쪽 서브트리 후위 순회
		System.out.println(node.data); // 현재 노드 데이터 출력
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;

		// 루트 노드 생성
		input = br.readLine();
		root = new Node(Integer.parseInt(input));

		// 나머지 노드 삽입
		while ((input = br.readLine()) != null && input.length() != 0) {
			int data = Integer.parseInt(input);
			insert(root, data);
		}

		// 후위 순회 결과 출력
		postorder(root);
	}
}