// 5585 - 거스름돈

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int init = Integer.parseInt(br.readLine());

		init = 1000 - init;

		int[] money = { 500, 100, 50, 10, 5, 1 };

		int count = 0;

		for (int i = 0; init != 0; i++) {
			count += init / money[i];

			init = init % money[i];
		}

		System.out.println(count);

	}

}
