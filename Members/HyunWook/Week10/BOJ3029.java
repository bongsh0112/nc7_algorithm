// 3029 - 경고

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 시작 시간을 입력받아서 초로 변환
		int sTime = timeToSeconds(br.readLine());
		// 종료 시간을 입력받아서 초로 변환
		int eTime = timeToSeconds(br.readLine());

		// 대기 시간 계산 (음수가 나올 수 있으므로 3600*24로 나눈 나머지 사용)
		int wait = (eTime + 24 * 3600 - sTime) % (3600 * 24);
		// 대기 시간을 시간, 분, 초로 변환
		int hour = wait / 3600, min = (wait % 3600) / 60, sec = wait % 60;

		// 시작 시간과 종료 시간이 같으면 24시간으로 출력, 아니면 시간을 형식에 맞게 출력
		System.out.printf(sTime == eTime ? "24:00:00" : "%02d:%02d:%02d\n", hour, min, sec);
		br.close();
	}

	// 시간 형식 (hh:mm:ss)을 초로 변환하는 함수
	static int timeToSeconds(String time) {
		StringTokenizer stk = new StringTokenizer(time, ":");
		return stoi(stk.nextToken()) * 3600 + stoi(stk.nextToken()) * 60 + stoi(stk.nextToken());
	}

	// 문자열을 정수로 변환하는 함수
	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
