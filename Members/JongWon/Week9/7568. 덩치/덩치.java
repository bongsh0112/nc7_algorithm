import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static int N = 0;
	private static List<Integer[]> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			String[] info = br.readLine().split(" ");
			list.add(new Integer[] { Integer.parseInt(info[0]), Integer.parseInt(info[1]), 1 });
		}

		IntStream.range(0, N - 1).forEach(i -> {
			Integer[] iInfo = list.get(i);
			IntStream.range(i + 1, N).forEach(j -> {
				Integer[] jInfo = list.get(j);
				if (iInfo[0] < jInfo[0] && iInfo[1] < jInfo[1])
					iInfo[2]++;
				else if (iInfo[0] > jInfo[0] && iInfo[1] > jInfo[1])
					jInfo[2]++;
			});
		});

		System.out.println(
				IntStream.range(0, N).mapToObj(i -> String.valueOf(list.get(i)[2])).collect(Collectors.joining(" ")));
	}

}
