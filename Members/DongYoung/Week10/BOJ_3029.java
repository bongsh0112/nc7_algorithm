package Members.DongYoung.Week10;

import java.util.Scanner;

public class BOJ_3029 {
    public static void main(String[]args) {
        Scanner scanner = new Scanner(System.in);

        String[] timeSplit1 = scanner.nextLine().split(":");
        String[] timeSplit2 = scanner.nextLine().split(":");
        


        int time1 =  (Integer.parseInt(timeSplit1[0]) * 3600) + (Integer.parseInt(timeSplit1[1]) * 60) + (Integer.parseInt(timeSplit1[2]));
        int time2 = (Integer.parseInt(timeSplit2[0]) * 3600) + (Integer.parseInt(timeSplit2[1]) * 60) + (Integer.parseInt(timeSplit2[2]));
        int time = 0;
        if (time1 == time2) {
            time = 24 * 3600;
        } else {
            time = (time2 - time1 + 24 * 3600) % (24 * 3600);
        }
        
        if (time == 0) {
            time = 1;
        }
        int hour = time / 3600;
        time = time% 3600;
        int min = time / 60;
        time = time % 60;
        int sec = time;
        StringBuffer sb = new StringBuffer("");
        if (hour < 10 ) {
            sb.append("0" + hour);
        } else {
            sb.append(hour);
        }
        sb.append(":");
        if (min < 10 ) {
            sb.append("0" + min);
        } else {
            sb.append(min);
        }
        sb.append(":");
        if (sec < 10 ) {
            sb.append("0" + sec);
        } else {
            sb.append(sec);
        }       
        System.out.println(sb.toString());
    }
}
