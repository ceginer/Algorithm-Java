import java.util.Scanner;

public class M_그리디1_동전개수최솟값 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // 동전 수 N
        int K = in.nextInt(); // 목표 금액 K
        int A[] = new int[N];
        for (int i =0; i<N; i++){
            A[i] = in.nextInt();
        }
        // 그리디 알고리즘
        int count = 0;
        // 큰 값 부터해서 목표금액 K를 큰값으로 나눈다.
        for (int i = N-1;i>=0;i--){
            if (A[i] <= K) {
                count += (K / A[i]);
                K = K % A[i];
            }
        }
        System.out.println(count);
    }
}
