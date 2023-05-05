import java.util.*;
import java.io.*;

public class BFSDFS_백준_토마토 {
    static int M,N;
    static int[][] map;
    static Queue<int []> que = new LinkedList<>();
    static boolean[][] visited;
    static int[] dx, dy;
    static int[][] minRoot;
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        dx = new int[] {0,0,-1,1};
        dy = new int[] {-1,1,0,0};

        map = new int[N][M];
        visited = new boolean[M][N];
        minRoot = new int[M][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(in.readLine());
            for(int j=0;j<M;j++){
                int tomato = Integer.parseInt(st.nextToken());
                if(tomato == 1){
                    que.offer(new int[] {j,i});
                    visited[j][i] = true;
                    minRoot[j][i] = 0;
                }
                map[i][j] = tomato;
            }
        }
        int max =0;

        while (!que.isEmpty()){
            int[] now = que.poll();
            for(int i=0;i<4;i++){
                int nX = now[0] + dx[i];
                int nY = now[1] + dy[i];
                if(nX >=0 && nY >=0 && nX < M && nY <N){
                    if(!visited[nX][nY] && map[nY][nX] == 0){
                        visited[nX][nY] = true;
                        minRoot[nX][nY] = minRoot[now[0]][now[1]]+1;
                        map[nY][nX] = map[now[1]][now[0]]+1;
                        if(max < minRoot[nX][nY] ){
                            max = minRoot[nX][nY];
                        }
                        que.offer(new int[] {nX,nY});
                    }
                }
            }
        }
        boolean isPossible = true;
        for(int i=0;i<M;i++){
            for(int j = 0;j<N;j++){
                if(map[j][i] == 0 ){
                    isPossible = false;
                }
            }
        }

        if(isPossible){
            System.out.println(max);
        } else{
            System.out.println(-1);
        }

    }
}
