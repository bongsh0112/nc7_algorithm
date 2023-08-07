// 2851 - 슈퍼 마리오

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int sum = 0; // 마리오가 받는 점수의 합을 저장하는 변수
		int target = 100; // 목표 점수인 100
		int[] mushRooms = new int[11]; // 버섯의 점수를 저장하는 배열

		for (int i = 1; i <= 10; i++) {
			mushRooms[i] = mushRooms[i - 1] + Integer.parseInt(br.readLine());
			if (target >= Math.abs(mushRooms[i] - 100)) {
				target = Math.abs(mushRooms[i] - 100);
				sum = mushRooms[i];
			}
		}
		System.out.println(sum);
	}
}

// ###코드 설명###

// BufferedReader를 사용하여 입력을 받기 위해 import java.io.BufferedReader;를 추가합니다.

// 버섯의 점수를 저장할 mushRooms 배열을 생성합니다. 배열의 크기를 11로 지정한 이유는
// 버섯의 점수를 입력받을 때 1번부터 10번까지 버섯의 순서대로 값을 저장하기 위해서입니다.

// for 루프를 사용하여 버섯의 점수를 입력받고, 슈퍼 마리오가 버섯을 먹을 때마다 받는 점수의 합을 계산합니다.

// mushRooms[i] = mushRooms[i - 1] + Integer.parseInt(br.readLine());: 버섯의 점수를
// 입력받은 후,
// mushRooms 배열에 1번 버섯부터 i번 버섯까지의 점수의 합을 저장합니다. 이렇게 함으로써,
// mushRooms[i]에는 1번 버섯부터 i번 버섯까지의 누적 점수가 저장됩니다.

// target 변수는 100에 가까운 수를 저장하는 변수입니다. 슈퍼 마리오가 받을 수 있는 점수의 합이 100과 가까울수록 좋으므로,
// 가장 가까운 값을 찾기 위해 사용합니다.

// if (target >= Math.abs(mushRooms[i] - 100)) { ... }: 버섯을 i번째까지 먹었을 때,
// 마리오가 받는 점수의 합과 100과의 차이(Math.abs(mushRooms[i] - 100))를 계산합니다.
// 이 값이 target보다 작거나 같으면, 즉 100에 가까운 점수의 합을 가졌다면 다음을 실행합니다.

// target = Math.abs(mushRooms[i] - 100);: target 변수에 100에 가까운 점수의 합과의 차이를
// 저장합니다.
// 이렇게 함으로써, 최대한 100에 가깝게 점수를 받을 수 있도록 합니다.

// sum = mushRooms[i];: 슈퍼 마리오가 받는 점수의 합을 mushRooms[i]로 설정합니다.
// 버섯을 i번째까지 먹었을 때의 누적 점수를 sum에 저장합니다.

// System.out.println(sum);: 슈퍼 마리오가 받는 점수의 합을 출력합니다.

// 이렇게 되면, 슈퍼 마리오가 버섯을 먹으며 받을 수 있는 점수의 합을 최대한 100에 가깝게 계산하고 출력하는 프로그램이 완성됩니다.