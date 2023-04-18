import java.util.ArrayList;
import java.util.Scanner;

public class 완전탐색_N과M_2 {
    static int N, M;
    static boolean visited[];
    static int[] answer;
    static ArrayList<int[]> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        M = in.nextInt();

        visited = new boolean[N+1];
        answer = new int[M+1];
        for (int i=1; i<=N; i++){
            // for문 증가할 때마다 index 바뀔거고, 그때마다 index에 맞는 값을 배열에 넣을거임 / 즉, for문에서 변하는 걸 매개변수로 넣은거임
            visited[i] = true;
            answer[0] = i;
            recursive(1);
        }

    }
    private static void recursive(int idx){
        if (idx == M){
            list.add(answer);
            return;
        }
        for (int i=1; i<=N; i++){
            if(!visited[i]){
                visited[i] = true;
                answer[idx] = i;
                recursive(idx+1);
                visited[i] =false;
            }
        }
    }
}
