import java.util.Scanner;

public class T_동적계획법_2xN타일채우기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // 2 * N 개 타일
        long D[] = new long[1001];
        // 초기값들 초기화하기
        D[1]=1;
        D[2] = 2;
        for(int i=3;i<=N;i++){
            D[i] = (D[i-1]+D[i-2]) % 10007;
        }
        System.out.println(D[N]);
    }
}
