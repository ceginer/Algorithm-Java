import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;

public class BFS_백준_숨바꼭질 {
    static int N,M;
    static int counter[] = new int[100001]; // 방문배열 겸, count 세는 counter
    static int[] dx = {1,-1,2};
//    static boolean visited[];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt(); // 현재 위치
        M = in.nextInt(); // 동생 위치
        counter[N] = 0;

        // 서로 처음부터 똑같은 예외상황 처리
        if (N == M){
            System.out.println(0);
        } else{
            bfs(N);
            System.out.println(counter[M]);
        }
    }

    private static void bfs(int current){
        Queue<Integer> que = new LinkedList<>();
        que.offer(current);
        // 방문배열 있을 자리 (처음 들어가는 숫자 방문배열 true 시켜주기)

        while(!que.isEmpty()){
            int now = que.poll();

            if(now == M) return;

            for(int i=0; i<3;i++){
                // 다음 가놓을 곳 미리 지정
                int next;
                if (i==2) {next = now*dx[i]; }
                else next = now+dx[i];

                if(next>=0 && next<=100000){ // 1. 범위벗어나지 않고
                    if(counter[next] == 0){ // 2. 방문배열에서 방문하지 않은 곳일 때,
                        // 만약 방문했을 때, 방문배열 true 시켜주는 자리 -> 여기서는 counter == 0 으로 대신 검사 가능

                        // 다음 방문 확정
                        counter[next] = counter[now] + 1;
                        que.add(next);
                    }
                }

            }

        }
    }
}
