package Members.DongYoung.Week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;

import java.lang.StringBuffer;
public class BOJ_7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        HashMap<String, Boolean> userMap = new HashMap<>();
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            String name = str.split(" ")[0];
            Boolean isEnter = str.split(" ")[1].equals("enter");
            userMap.put(name,isEnter);
        }
        br.close();
        System.out.println("--------------------------");
        ArrayList<String> answers = new ArrayList<>();
        for(Map.Entry<String, Boolean> entry :userMap.entrySet()) {
            if(entry.getValue()) {
                answers.add(entry.getKey());
            }
        }
        Collections.sort(answers,Collections.reverseOrder());
        
        StringBuffer sb = new StringBuffer();

        for(String a : answers) {
            sb.append(a);
            sb.append("\n");
        }
        System.out.println(sb.toString());
        

    }
}
