package Members.DongYoung.Week10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BOJ_1991 {
    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        HashMap<String,String[]> treeMap = new HashMap<>();
        String root = "";
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            if (i == 0) {
                root = split[0];
            }
            treeMap.put(split[0],new String[]{split[1],split[2]});
        }
        StringBuffer sb1 = new StringBuffer("");
        recursive1(sb1,treeMap,root);
        System.out.println(sb1.toString());

        StringBuffer sb2 = new StringBuffer("");
        recursive2(sb2,treeMap,root);
        System.out.println(sb2.toString());

        StringBuffer sb3 = new StringBuffer("");
        recursive3(sb3,treeMap,root);
        System.out.println(sb3.toString());

    }

    static public void recursive3(StringBuffer sb, HashMap<String,String[]> treeMap, String a) {
        
        String[] arr = treeMap.get(a);
        if (!arr[0].equals(".")) {
            recursive3(sb, treeMap, arr[0]);
        }
        if (!arr[1].equals(".")) {
           recursive3(sb, treeMap, arr[1]);
        }
        sb.append(a);
    }

    static public void recursive2(StringBuffer sb, HashMap<String,String[]> treeMap, String a) {
        
        String[] arr = treeMap.get(a);
        if (!arr[0].equals(".")) {
            recursive2(sb, treeMap, arr[0]);
        }
        sb.append(a);
        if (!arr[1].equals(".")) {
           recursive2(sb, treeMap, arr[1]);
        }
    }

    static public void recursive1(StringBuffer sb, HashMap<String,String[]> treeMap, String a) {
        
        String[] arr = treeMap.get(a);
        sb.append(a);
        if (!arr[0].equals(".")) {
            recursive1(sb, treeMap, arr[0]);
        }
        if (!arr[1].equals(".")) {          
           recursive1(sb, treeMap, arr[1]);
        }
    }
}
