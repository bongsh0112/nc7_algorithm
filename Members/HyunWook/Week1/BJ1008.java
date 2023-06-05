import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double A = sc.nextInt();    //double형 타입은 소수 14자리까지 오차없이 표현할 수 있다. 하지만 그 이상의 소수 부분을 표현할 때는 언제나 작은 오차가 발생하는지 나타나지 않는다.
        double B = sc.nextInt();
        System.out.println(A/B);
    }
}