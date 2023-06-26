import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int cnt = 0;
        int d = 0;
        int h = 0;
        if(b + c >= 60) {
            d = (b + c) % 60;
            cnt = (b + c) / 60;
        }else {
            d = b + c;
        }
        if((a + cnt) >= 24){
            h = a + cnt - 24;
        }else{
            h = a + cnt;
        }

        System.out.println((h) + " " + d);
    }
}