import java.io.*;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class J_DFS_연결요소개수 {
    // 방문 배열 visited[],
    // 인접 리스트의 묶음 리스트 = ArrayList<> []
    static boolean visited[];
    static ArrayList<Integer>[] A;

    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader 와 짝꿍인 StringTokenizer
        StringTokenizer st = new StringTokenizer((in.readLine()));
        // 노드 개수 n, 에지 개수 m
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        // 방문 배열 visited[],
        // index 0인 곳은 비워두기 위해 n+1로 한칸 더 만듬
        visited = new boolean[n+1];
        // 인접리스트들의 묶음 = new ArrayList[]
        A = new ArrayList[n+1];

        // 인접리스트의 묶음, arrayList A[] 배열 각각의 값 초기화
        for (int i =1; i<n+1; i++){
            A[i] = new ArrayList<Integer>();
        }
        // 입력받는 값들 인접리스트에 넣어주기
        for (int i =1; i<m+1; i++){
            st = new StringTokenizer((in.readLine()));
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            // 방향에 상관없는 그래프이므로, 양쪽에 각각 add
            A[start].add(end);
            A[end].add(start);
        }
        // 연결 개수 count
        int count =0;
        for(int i =0; i<n; i++){
            // 방문배열에서 false, 즉 방문하지 않은 것에 대해 count++
            if(!visited[i]){
                count ++;
                DFS(i);
            }
        }
    }

    private static void DFS(int v) {
        if(visited[v]){
            return;
        }
        visited[v] = true;
        // 현재 노드의 연결 노드 중 방문하지 않은 노드
        for(int i : A[v]){
            // 계속 탐색한다면 visited[i] 가 false여야 함, 그래서 if(!visited[i]) 문이 있는 것임.
            // visited 가 true인 경우 아무런 조건도 제시하지 않았기에, 알아서 루프를 모두 돌고 빠져나옴
            if(!visited[i]){
                DFS(i);
            }
        }

    }

}
