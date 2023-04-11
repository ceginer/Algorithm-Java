import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class P_그래프표현_이분그래프판별 {
    static boolean visited[]; // 방문 배열
    static ArrayList<Integer>[] A; // 인접 리스트 묶음배열
    static boolean isEven; // 이분 그래프 판별
    static int[] check; // 집합 같은지 다른지 판별, 0과 1로 구분
    public static void main(String[] args) throws IOException {
        // 그래프에서는 엣지 개수가 많기 때문에 BufferedReader 많이 사용함
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(in.readLine());

        // 테스트 케이스 개수만큼 반복해서 입력받기
        for (int t =0; t<testCase; t++){
            // 노드, 에지 개수 입력 V,E
            String[] s = in.readLine().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            // 배열 및 사전세팅 초기화
            A = new ArrayList[V+1]; // 0은 취급 X, 1부터 시작
            visited = new boolean[V+1];
            check = new int[V + 1];
            isEven = true;
            for (int i =1; i<=V; i++){
                A[i] = new ArrayList<Integer>();
            }
            // 에지 개수(E)만큼 정보 입력받음.(선 개수만큼 연결된 정보가 있겠지)
            // 정보 입력 받으면, 연결된 정보를 ArrayList<> 에 넣어야지
            for(int i =0; i<E; i++){
                s = in.readLine().split(" ");
                int start = Integer.parseInt(s[0]);
                int end = Integer.parseInt(s[1]);
                // 방향이 없으므로 서로 넣어주기
                A[start].add(end);
                A[end].add(start);
            }
            // 이제부터 시작, 사전세팅 끝
            // 모든 노드에서 DFS 실행해야 함
            for (int i=1; i<=V; i++){
                if (isEven){ // 이분 그래프일 때 계속 실행
                    DFS(i);
                }else break; // 이분그래프 아니면 바로 break
            }
            if(isEven){
                System.out.println("YES");
            } else System.out.println("NO");
        }
    }
    // 항상 또다른 메서드 만들 때 static!! 객체 필요없게!!!
    private static void DFS(int start){
        // DFS 거름망 ON, 통과했다는 도장부터 쾅!
        visited[start] = true;
        // 모든 인접리스트에 관해 DFS 시작
        for (int i : A[start]){
            if(!visited[i]){ // 방문 안했었네?
                // 각 인접리스트마다의 탐색 시작 전 집합 특성 부여하기
                // 0과 1로만 부여하기 위해 %2 사용
                check[i] = (check[start]+1) % 2;
                DFS(i);
            }else { // 방문 했었네? 너 집합특성 뭐야?
                if(check[start] == check[i]){
                    isEven = false;
                }
            }
        }
    }
}
