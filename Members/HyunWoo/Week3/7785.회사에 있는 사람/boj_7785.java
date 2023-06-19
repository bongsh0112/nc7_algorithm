import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class boj_7785 {
	
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		 
		int num = sc.nextInt();
		for (int i = 0; i < num; i++) {
			String people = sc.next();
			String inout = sc.next();
			if (inout.equals("enter")) {
				list.add(people);
			} else {
				list.remove(people);
			}
		}

		String[] arr = list.toArray(new String[0]);
		Arrays.sort(arr);
		for (int i = arr.length - 1; i >= 0; i--) {
			System.out.println(arr[i]);
		}
		
		sc.close();
	}
}

// 시간 초과 
