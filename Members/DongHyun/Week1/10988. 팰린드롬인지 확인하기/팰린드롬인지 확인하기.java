import java.io.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int answer = 1;
        char [] sArr = s.toCharArray();
        for(int i = 0; i < s.length()/2; i++) {
            if(sArr[i] != sArr[s.length()-1-i]) {
                answer = 0;
            }
        }
        System.out.println(answer);
    }
}

