import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//입력에서 단. 한개만 들어옴
		String strN = st.nextToken();
		int N = Integer.parseInt(strN);
		int answer = 0;
		for(int i = 0 ; i <= N; i++){
			int number = i;
			int sum = 0; 
			
			while(number != 0) {
				sum += number % 10;
				number = number / 10;
			}
			
			if(sum + i == N) {
				answer = i;
				break;
			}			
		}
		System.out.println(answer);
	}
}