import java.util.Scanner;

public class BOJ_1978 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int No;

        No = Integer.parseInt(scanner.nextLine());

        int [] arr = new int [No];

        String[] splitList = scanner.nextLine().split(" ");
        for(int i = 0; i < splitList.length; i++) {
            arr[i] = Integer.parseInt(splitList[i]);
        }
        boolean isDecimal = true;
        int result = 0;
        for(int i = 0; i < arr.length; i++) {
            isDecimal = true;
            for(int j = 2; j * j <= arr[i]; j++) {
                if(arr[i] % j == 0) {
                    isDecimal = false;
                }
            }
            if( arr[i] == 1) {
                isDecimal = false;
            }
            if (isDecimal) {
                result++;
            }
        }
        System.out.println(result);
        scanner.close();
    }
}
