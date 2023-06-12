import java.util.Scanner;

public class BOJ_5086 {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);

        String str = "";
        String [] strArr = new String[2];
        while (true) {
            str = scanner.nextLine();
            if(str.equals("0 0")) {
                break;
            }
            strArr = str.split(" ");
            int No1 = Integer.parseInt(strArr[0]);
            int No2 = Integer.parseInt(strArr[1]);
            if( No1 > No2) {
                if ( No1 % No2 == 0) {
                    System.out.println("multiple");
                } else {
                    System.out.println("neither");
                }
            } else {
                if ( No2 % No1 == 0) {
                    System.out.println("factor");
                } else {
                    System.out.println("neither");
                }
            }
        }
        scanner.close();
    }
}
