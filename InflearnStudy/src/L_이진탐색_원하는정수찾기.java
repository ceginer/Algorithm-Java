import java.util.Arrays;
import java.util.Scanner;

public class L_이진탐색_원하는정수찾기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // 데이터 개수 N
        int[] A = new int[N];
        for(int i =0;i<N; i++){
            A[i] = in.nextInt();
        }
        // 이진탐색은 정렬된 배열에 관해 적용가능함
        Arrays.sort(A);
        int M = in.nextInt(); // 찾아야 할 숫자 개수 M
        for(int i =0;i<M; i++){
            int target = in.nextInt();
            boolean find = false;
            int start = 0;
            int end = A.length -1;
            // 반복은 start 지점이 end 지점보다 클 때 게속 진행됨
            // 만약 start 지점이 end 보다 작아질 때 반복 탈출
            while(start <= end){
                int mid_index = (start+end)/2;
                int mid_value = A[mid_index];
                if (mid_value>target){
                    end = mid_index-1;
                }else if (mid_value<target){
                    start = mid_index+1;
                } else {
                    find = true;
                    break;
                }
            }
            if (find){
                System.out.println(1);
            } else{
                System.out.println(0);
            }
        }
    }
}
