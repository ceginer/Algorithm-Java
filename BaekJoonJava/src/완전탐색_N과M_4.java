import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 완전탐색_N과M_4 {
    static int[] answer;
    static int N,M;
    static StringBuilder sb = new StringBuilder();
//    static boolean [] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = new int[M];
//        visited = new boolean[N+1];

        recursive(0,1);
        System.out.println(sb);
    }

    private static void recursive(int depth, int start){
        if (depth == M){
            for (int i : answer){
                sb.append(i).append(' ');
            }
            sb.append('\n');

            return;
        }
        for(int i=start; i<=N; i++){
            answer[depth] = i;
            recursive(depth+1, i);
        }
    }
}
