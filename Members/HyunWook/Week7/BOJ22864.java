
// 22864 - 피로도
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken()); // 하루에 한시간 일해 쌓인 피로도
		int B = Integer.parseInt(st.nextToken()); // 하루 한시간에 일한 양
		int C = Integer.parseInt(st.nextToken()); // 한시간을 쉬면 줄어드는 피로도
		int M = Integer.parseInt(st.nextToken()); // 최대한의 피로도(번아웃을 막기 위한 최대값)

		int workedHour = 0; // 하루에 일한 양의 총합
		int fatigue = 0; // 하루에 쌓인 피로도 총합

		for (int i = 0; i < 24; i++) {
			if (fatigue + A <= M) {
				workedHour += B; // 일한 양을 누적
				fatigue += A; // 피로도를 쌓는다
			} else { // 일을 할 수 없는경우 ==> if(fatigue + A > M)
				fatigue -= C; // fatigue에서 C만큼 피로도를 감소시킵니다. 단, 피로도가 음수로 내려가면 0으로 조정합니다.
				if (fatigue < 0)
					fatigue = 0;
			}
		}
		System.out.print(workedHour);
	}
}
