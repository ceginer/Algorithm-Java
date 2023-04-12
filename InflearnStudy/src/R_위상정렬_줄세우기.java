import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class R_위상정렬_줄세우기 {
    static int [] indegree;
    static ArrayList<Integer>[] A;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // 노드 개수 = 학생 수 = N
        int M = in.nextInt(); // 에지 개수 = 질의 개수 = M
        A = new ArrayList[N+1]; // 이렇게 해야 A[N]인 공간이 만들어짐
        indegree = new int[N+1];
        for (int i =1; i<=N; i++){
            A[i] = new ArrayList<>();
        }
        // 사전 세팅
        //압력 받으면서 사전 코딩에 모든 데이터 입력
        for (int i = 0; i < M; i++) {
            int S = in.nextInt(); // 학생 1 = S
            int V = in.nextInt(); // 학생 2 = V
            A[S].add(V);
            indegree[V]++;
        }
        // 실제 코딩1 - queue 에 전입차수 0인 노드 채우기
        Queue<Integer> myQueue = new LinkedList<>();
        for (int i=1;i<=N; i++){
            if (indegree[i] ==0){
                myQueue.offer(i);
            }
        }
        // 실제 코딩2 - queue 에서 노드 꺼내서 계속 이어나가기
        while (!myQueue.isEmpty()){
            int now = myQueue.poll();
            System.out.print(now + " ");
            for (int next : A[now]){
                indegree[next]--;
                if(indegree[next] == 0){
                    myQueue.offer(next);
                }
            }
        }





    }
}
