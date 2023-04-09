import java.util.Scanner;

public class H_버블정렬 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 수의 개수 N
        int N = in.nextInt();
        int A[] = new int[N];

        // 정렬될 수들 입력받기. 배열 A[]
        for (int i =0; i<N; i++){
            A[i] = in.nextInt();
        }

        // 버블정렬 구현
        for (int i=0;i<N-1; i++){
            for (int j =0; j<N-1-i; j++){
                if(A[j]>A[j+1]){
                    int temp = A[j+1];
                    A[j+1] = A[j];
                    A[j] = temp;
                }
            }
        }
        for (int i=0; i<N; i++){
            System.out.println(A[i]);
        }
    }
}
