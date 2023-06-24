import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// https://data-make.tistory.com/524 참고하였음.

public class 구현_백준미세먼지안녕 {
    static int[][] map;
    static boolean[][] visited;
    static int R,C,T;
    static int[] dx,dy;
    static List<Dust> dusts;
    static int cleaner = -1;
    static class Dust{
        int x;
        int y;
        int w;
        public Dust(int x, int y, int w){
            this.x= x;
            this.y= y;
            this.w= w;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        visited = new boolean[R][C];
        map = new int[R][C];

        dx = new int[] {0,0,1,-1};
        dy = new int[] {1,-1,0,0};

        // 1. map 배열 복사
        for(int i=0;i<R;i++){
            st = new StringTokenizer(in.readLine());
            for(int j =0; j<C; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == -1 && cleaner == -1){
                    cleaner = i;
                }
            }
        }
        for(int i=0;i<T;i++){
            //2. 확산
            spread();

            // 3. 공기청정기 작동
            operate();
        }


        int sum = 0;
        // 4. 전체 미세먼지 수
        for(int i=0;i<R;i++){
            for(int j =0; j<C; j++){
                if(map[i][j] != -1){
                    sum += map[i][j];
                }
            }
        }

        System.out.println(sum);
    }
    private static void spread(){
        Queue<Dust> que = new LinkedList<>();
        for(int i=0;i<R;i++){
            for(int j =0; j<C; j++){
                if(map[i][j] != -1){
                    que.offer( new Dust(i,j,map[i][j]) );
                }
            }
        }
        visited[0][0] = true;

        while(!que.isEmpty()){
            Dust now = que.poll();
            if(now.w < 5) continue;
            int amountOfSpread = now.w/5;
            int count = 0;
            for(int k=0;k<4;k++){
                int xx = now.x+dx[k];
                int yy = now.y+dy[k];
                if(xx >=0 && yy >= 0 && xx <R && yy < C){
                    if(!(map[xx][yy] == -1)){
                        map[xx][yy] += amountOfSpread;
                        count +=1;
                    }
                }
            }
            map[now.x][now.y] = map[now.x][now.y] - amountOfSpread*count;
        }
    }
    private static void operate(){
        int top = cleaner;
        int bottom = cleaner+1;

        for(int i=cleaner-1;i>0;i--){
            map[i][0] = map[i-1][0];
        }
        for(int i=0;i<C-1;i++){
            map[0][i] = map[0][i+1];
        }
        for(int i=0;i<top;i++){
            map[i][C-1] = map[i+1][C-1];
        }
        for(int i=C-1;i>1;i--){
            map[top][i] = map[top][i-1];
        }
        map[top][1] = 0;

        for (int i = bottom + 1; i < R - 1; i++)
            map[i][0] = map[i + 1][0];
        // 왼쪽으로 당기기
        for (int i = 0; i < C - 1; i++)
            map[R - 1][i] = map[R - 1][i + 1];
        // 아래로 당기기
        for (int i = R - 1; i > bottom; i--)
            map[i][C - 1] = map[i - 1][C - 1];
        // 오른쪽으로 당기기
        for (int i = C - 1; i > 1; i--)
            map[bottom][i] = map[bottom][i - 1];
        // 공기청정기에서 부는 바람은 미세먼지가 없는 바람
        map[bottom][1] = 0;


    }
}
