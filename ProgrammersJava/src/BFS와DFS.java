import java.sql.Array;
import java.util.*;
import java.io.*;

public class BFS와DFS {
    static ArrayList<Integer>[] A;
    static Queue<Integer> que;
    static boolean visited[];
    static int N, M, v;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());


        N = Integer.parseInt(st.nextToken()); // 노드
        M = Integer.parseInt(st.nextToken()); // 간선
        v = Integer.parseInt(st.nextToken()); // 탐색 시작 번호

        A = new ArrayList[N+1];
        que = new LinkedList<>();

        for(int i=1;i<=N;i++){
            A[i] = new ArrayList<Integer>();
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            A[a].add(b);
            A[b].add(a);
        }
        for(int i=1; i<=N; i++){
            Collections.sort(A[i]);
        }

        visited = new boolean[N+1];
        visited[v] = true;
        dfs(0, v);
        System.out.println();
        visited = new boolean[N+1];
        bfs(v);

    }
    private static void dfs(int depth, int start){
        System.out.print(start+ " ");

        for(int i : A[start]){
            if(!visited[i]){
                visited[i] = true;
                dfs(depth +1, i);
            }
        }
    }
    private static void bfs(int start){
        que.offer(start);
        visited[start] = true;

        while(!que.isEmpty()){
            int now = que.poll();
            System.out.print(now + " ");
            for( int i : A[now]){
                if(!visited[i]){
                    visited[i] = true;
                    que.offer(i);
                }
            }
        }
    }
}
