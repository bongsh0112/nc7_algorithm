// 20440 🎵니가 싫어 싫어 너무 싫어 싫어 오지 마 내게 찝쩍대지마🎵 - 1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

// Time 클래스는 시작 시간과 종료 시간을 저장하는 객체
// Comparable 인터페이스를 구현하여 정렬을 위해 비교 기준을 제공
// Comparable 인터페이스를 구현함으로써 Time 객체들 간의 정렬 순서를 결정할 수 있습니다. 
class Time implements Comparable<Time> {
	long start;
	long end;

	public Time(long start, long end) {
		this.start = start;
		this.end = end;
	}

	// compareTo 메서드는 두 개의 Time 객체를 비교하여 정렬 순서를 반환합니다.
	// compareTo 메서드를 사용하여 end 시간을 기준으로 오름차순으로 정렬합니다.
	// end 시간이 같은 경우에는 start 시간을 기준으로 오름차순 정렬합니다.
	// 이렇게 정렬 기준을 제공함으로써, 시간대를 관리하고 필요한 순서로 정렬할 수 있게 됩니다
	// 따라서, Time 클래스를 사용한 이유는 시간대의 정렬을 위한 비교 기준을 제공하기 위해서입니다.
	@Override
	public int compareTo(Time o) {
		if (this.end < o.end) {
			return -1;
		} else if (this.end == o.end) {
			if (this.start < o.start) {
				return 1;
			} else {
				return -1;
			}
		} else {
			return 1;
		}
	}
}

public class Main {
	static int n;
	static long[][] arr;
	static long a, b;
	static PriorityQueue<Time> queue = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		// 입력된 시간표를 배열 arr에 저장합니다. 이때, 시작 시간과 종료 시간을 long 타입으로 변환하여 저장
		arr = new long[n][2];

		for (int i = 0; i < n; i++) {
			String[] s = br.readLine().split(" ");
			arr[i][0] = Long.parseLong(s[0]);
			arr[i][1] = Long.parseLong(s[1]);
		}

		Arrays.sort(arr, (a, b) -> {
			if (a[0] <= b[0]) {
				return -1;
			} else {
				return 1;
			}
		});
		// 변수 max를 0으로 초기화합니다. max는 최대로 중복되지 않는 시간대의 개수
		// 반복문을 사용하여 시간표를 순회하면서 최대 중복되지 않는 시간대를 선택
		int max = 0;
		for (int i = 0; i < n; i++) {
			// queue에서 현재 시간보다 종료 시간이 작은 시간대를 제거합니다. 이는 이미 지나간 시간대를 제외하기 위함입니다.
			while (!queue.isEmpty() && arr[i][0] > queue.peek().end) {
				queue.poll();
			}
			// 만약 queue가 비어있지 않고, 현재 시간과 종료 시간이 같은 시간대가 있는 경우,
			// 해당 시간대를 제거하고 종료 시간을 업데이트합니다.
			if (!queue.isEmpty() && arr[i][0] == queue.peek().end) {
				if (queue.peek().end == b) {
					b = arr[i][1];
				}
				// 현재 시간대를 queue에 추가합니다.
				queue.poll();
			}
			queue.add(new Time(arr[i][0], arr[i][1]));
			// 만약 queue의 크기가 max보다 크다면, max를 업데이트하고, 시작 시간과 종료 시간을 저장합니다.
			// 반복이 완료되면 max에는 최대 중복되지 않는 시간대의 개수가 저장되고,
			// a와 b에는 해당 시간대의 시작 시간과 종료 시간이 저장됩니다.
			if (queue.size() > max) {
				max = queue.size();
				a = arr[i][0];
				b = queue.peek().end;
			}
		}
		System.out.println(max);
		System.out.println(a + " " + b);
	}
}
