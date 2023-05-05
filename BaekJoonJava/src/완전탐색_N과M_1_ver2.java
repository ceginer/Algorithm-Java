import java.util.Arrays;
import java.util.Scanner;

public class 완전탐색_N과M_1_ver2 {
    static int N, M;
    static boolean visited[];
    static int[] answer;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        M = in.nextInt();

        visited = new boolean[N+1];
        answer = new int[M];

        recursive(0); // idx = depth // 보통은 depth 가 항상 매개변수에 들어감 ----1

    }
    private static void recursive(int idx){
        if(idx == M){ // --------탈출조건이나 예외 세워야지---------------------3
            for (int i = 0; i < M; i++) {// -----가장 마지막에 해야할 일을 여기다가 처리하면 돼~-----------4
                System.out.print(answer[i] + " ");
            }
            System.out.println();
            return; // -------여기서 return 하게 되면 사실상 가장 큰 for문을 탈출하는 거라 보면 돼~ 이제부터 i=2의 for문이 시작하지~ ----5
        }
        for (int i=1;i<=N; i++){ // 1~N까지 돌려줄꺼니가 i=1~N 까지, 방문배열로 나중에 처리해줄거----2
            if(!visited[i]){ // 이건 루프속의 공간이니, 방문배열로 거르는 것부터 시작해야지, 여기부터가 for문 돌고있을동안의 일들이지.
                visited[i] = true; // 방문된거는 true 처리
                answer[idx] = i; // depth 가 0부터 시작하니까 이걸 인덱스로 answer 값을 하나씩 채워나가야지
                recursive(idx +1); // 여기가 2번째 for문으로 들어가는 곳이니깐 어떻게 매개변수 적을지 생각해봐바
                // depth 하나 추가하는건 무조건이지~, 2번째 for문으로 다시 들어가기 전에 해야할 일들은 다 처리했는지 보고, 매개변수 어쩔까?
                visited[i] = false; // 만약 1첫번째 for문을 다 돌았으면 빠져나오면서 문닫을지 생각해야지, 왠만하면 닫을걸~?
            }
        }
    }
}
