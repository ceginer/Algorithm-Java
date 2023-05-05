import java.util.Arrays;
import java.util.Scanner;

public class 완전탐색_N과M_2_ver2 {
    static int N, M;
    static boolean visited[];
    static int[] answer;

    public static void main(String[] args) {
        Scanner in = new Scanner((System.in));
        N = in.nextInt();
        M = in.nextInt();

        visited = new boolean[N+1];
        answer = new int[M];

        recursive(0,1); //depth =index --흠 여기서는 차례로 계속 커져나가니깐 start라는 새로운 매개변수를 줘볼까?-----1

    }
    private static void recursive(int depth, int start){
        if (depth == M){ // 탈출 조건이나 예외조건~------3
            for (int i : answer){
                System.out.print(i +" "); // 탈출하기 전 가장 마지막 할 일~-----4
            }
            System.out.println();
            return; // 이제야 첫번째 for문 탈출하는 거야~------55
        }
                                                //--------------------1
        for (int i=start; i<=N; i++){ // 이전에는 방문배열로 for문 제어했는데 (i=1에서는 234가, i=2에서는 134가 들어오게 했는데) 여기는 아예 시작을 다르게 해보자구?---2
            if(!visited[i]){ // 다시 막고~
                visited[i] = true; // true는 기본이구~
                answer[depth] = i; // 2번째 for문으로 들어가야지? depth 만큼 인덱스를 나타내주는 건, 1번째for문의 depth는 항상1, 2번째 for문의depth는 항상2 이런식으로 가기때문이이야
                recursive(depth+1, i+1); // depth+1 은 거의 고정이구, 시작하는 지점이 계속 달라지게 하면 되잖아? 그래서 depth랑 상관없이 시작하는 i+1로 하면 잘 되지~
                visited[i] =false; // for문의 첫번째가 끝날 때는 다시 모든 방문배열을 초기화해야지
            }                                   ///--------------1
        }
    }
}

