
import java.io.*;
import java.util.*;

public class C2_투포인터_주몽명령 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        // 숫자 개수 N개
        int N = Integer.parseInt(in.readLine());
        // 목표하는 값 M
        int M = Integer.parseInt(in.readLine());
        int[] A = new int[N];
        // 공백 제거 + 하나씩 token 으로 만듬
        StringTokenizer token = new StringTokenizer(in.readLine());
        for (int i=0; i<N; i++){
            A[i] = Integer.parseInt(token.nextToken());
        }
        // 1- 오름차순 정렬
        Arrays.sort(A);
        // 정답 개수
        int count =0;
        int i = 0;// Min
        int j = N-1; // Max
        while(i<j){
            if(A[i]+A[j] < M) i++;
            else if (A[i]+A[j] > M) j--;
            else {
                count++; // ++ 의 경우 잘못될 수 있으니 이렇게 {]안에 표현
                i++; j--;
            }
        }
        System.out.println(count);

    }
}
