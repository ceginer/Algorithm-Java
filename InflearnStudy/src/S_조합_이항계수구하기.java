import java.util.Scanner;

public class S_조합_이항계수구하기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // 전체 수 N
        int M = in.nextInt(); // 고르는 개수 M
        // 전체 배열은 (N+1)*(N+1) 개 (index 0 은 무시)
        int D [][] =new int[N+1][N+1];
        // 조합 배열 초기화
        for (int i=0; i<=N; i++){
            D[i][1] = i;
            D[i][0] = 1;
            D[i][i] = 1;
        }
        // 점화식 적용
        for(int i=2;i<=N;i++){
            for (int j=1;j<i;j++){
                D[i][j]= D[i-1][j] + D[i-1][j-1];
            }
        }
        System.out.println(D[N][M]);
    }
}
