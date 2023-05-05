import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BFS_백준_순열사이클 {
    static boolean[] visited;
    static ArrayList<Integer>[] A;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());

        for(int l=0;l<T;l++){
            count =0;
            int N = Integer.parseInt(in.readLine());

            visited = new boolean[N+1];
            A = new ArrayList[N+1];
            for(int i=1;i<=N;i++){
                A[i] = new ArrayList<>();
            }

            StringTokenizer st = new StringTokenizer(in.readLine());
            for(int i =1; i<=N;i++){
                int a = Integer.parseInt(st.nextToken());
                A[i].add(a);
            }

            for(int i=1;i<=N;i++){
                if(!visited[i]){
                    dfs(i);
                    count++;
                }
            }

            System.out.println(count);

        }
    }
    private static void dfs(int start){

        for(int i : A[start]){
            if(!visited[i]){
                visited[i] = true;
                dfs(i);
            }
        }
    }
}