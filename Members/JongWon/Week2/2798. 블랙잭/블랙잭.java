
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		String[] cardList = br.readLine().split(" ");

		int N = Integer.parseInt(NM[0]); // N
		int M = Integer.parseInt(NM[1]); // M

		int maxCardNum = Integer.MIN_VALUE;
		// 100 * 99 * 98
		// Max 100
		for (int firstCard = 0; firstCard < N; firstCard++) {
			// Max 100-1
			for (int secondCard = 0; secondCard != firstCard && secondCard < N; secondCard++) {
				// Max 100-2
				for (int thirdCard = 0; thirdCard != firstCard && thirdCard != secondCard && thirdCard < N; thirdCard++) {
					int cardSum = Integer.parseInt(cardList[firstCard]) +
							Integer.parseInt(cardList[secondCard]) +
							Integer.parseInt(cardList[thirdCard]);
					if (cardSum <= M) {
						maxCardNum = Math.max(maxCardNum, cardSum);
					}

				}
			}
		}

		System.out.println(maxCardNum);
	}
}