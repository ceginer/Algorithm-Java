import java.io.BufferedReader;
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 백준_BFS_DFS_섬의개수 {
    static int w, h;
    static boolean visited[][];
    static int[] dx,dy;
    static int count=0;
    static int[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        dx = new int[] {0,0,-1,1,1,1,-1,-1};
        dy = new int[] {1,-1,0,0,1,-1,-1,1};

        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        while (!(w==0 && h ==0)){

            visited = new boolean[w][h];

            map = new int[h][w];

            for(int i =0; i<h; i++){
                st = new StringTokenizer(in.readLine());
                for(int j =0; j<w; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i=0; i<w; i++){
                for(int j =0; j<h;j++){
                    if(!visited[i][j] && map[j][i] == 1){
                        visited[i][j] = true;
                        dfs(i,j);
                        count++;
                    }
                }
            }

            System.out.println(count);
            st = new StringTokenizer(in.readLine());

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            count = 0;
        }

    }
    private static void dfs(int x, int y){

        for(int i=0;i<8;i++){
            int nX = x+dx[i];
            int nY = y+dy[i];

            if(nX >= 0 && nY >=0 && nX <w && nY <h){
                if(!visited[nX][nY] && map[nY][nX] == 1){
                    visited[nX][nY] = true;
                    dfs(nX, nY);
                }
            }

        }
    }
}
