import java.util.Scanner;

public class b2525 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int hh, mm, time;
        hh = mm = time = 0;
        hh = sc.nextInt();
        mm = sc.nextInt();
        time = sc.nextInt();

        mm += time;

        while(mm >= 60){
            hh++;
            mm -= 60;
        }
        if(hh >= 24){
            hh -= 24;
        }
        if(mm == 60){
            hh++;
            mm = 0;
        }

        System.out.println(hh + " " + mm);
        sc.close();
    }
}
