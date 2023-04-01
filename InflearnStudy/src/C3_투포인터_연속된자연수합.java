import java.util.*;

// 주어진 숫자가 N일 때,
// start_index, end_index 2개가 각각 N번 만큼 이동하므로
// 시간복잡도는 O(N) 이다.
public class C3_투포인터_연속된자연수합 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int N = in.nextInt();
        int count= 1;
        int start_index = 1;
        int end_index = 1;
        int sum = 1;
        while (end_index != N){
            if (sum == N){
                count++; end_index++; sum = sum + end_index;
            } else if (sum > N){
                sum = sum - start_index;
                start_index++;
            } else {
                end_index++; sum = sum + end_index;
            }
        }
        System.out.println(count);
    }
}