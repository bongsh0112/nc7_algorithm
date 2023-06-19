import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class Main {
    static int[] tmp;
    private static void merge(int[] org, int stNum , int edNum ){
        if( stNum < edNum){
            int mid = (stNum + edNum) / 2;
            merge(org, stNum, mid); 
            merge(org, mid + 1, edNum);
            mergeSort(org, stNum, mid, edNum);
        }
    }
    private static void mergeSort(int[] arr, int stNum, int mid, int edNum){
        int p = stNum;
        int q = mid + 1;
        int idx = stNum;

        while( p<=mid || q<=edNum ){
            if(q>edNum||(p<=mid && arr[p]<arr[q]))
                tmp[idx++] = arr[p++];
            else
                tmp[idx++] = arr[q++];
        }
        for(int i =stNum; i<=edNum; i++)
            arr[i] = tmp[i];
    }
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int total = Integer.parseInt(br.readLine());
        int[] ary = new int[total+10];
        for(int i = 0; i < total; i++)
            ary[i] = Integer.parseInt(br.readLine());
        tmp = new int[total+10];
        merge(ary,0,total-1);
        for(int i =0; i< total; i++)
            bw.write(String.valueOf(ary[i])+"\n");
        bw.close();
	}
}