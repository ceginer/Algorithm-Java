import java.util.Scanner;

public class O_소수구하기_소수구해야지 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int M = in.nextInt(); // 시작 수 M
        int N = in.nextInt(); // 끝 수 N
        int[] A = new int[N + 1]; // 처음부분은 비울 것이기에 [N+1]개 만들기
        // 각 배열을 index 값으로 설정
        for (int i = 1; i <= N; i++) {
            A[i] = i;
        }
        // 루트(끝 수) 만큼만 배수 따져보면 됨 + 1은 소수에서 제외
        for (int i = 2; i <= Math.sqrt(N); i++){
            if(A[i]==0)continue;
            // j 시작: i의 2배=i+i
            // j 끝 : 계속해서 i만큼 증가할 수 있도록 j=i+j, 끝 수 N까지
            // 배수인 것만 0으로 처리
            for(int j=i+i; j<=N; j=i+j){
                A[j] = 0;
            }
        }
        for (int i = M; i<=N; i++){
            if(A[i]!=0){
                System.out.println(A[i]);
            }

        }
    }
}
