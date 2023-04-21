import java.util.*;

public class BFS_게임맵최단거리 {

    class Solution1 { // 이게 solution2 를 고친 것, 더 깔끔하게 작성한 것으로 이것만 보면 됨.
        static boolean[][] visited;
        static int[][] minRoot;
        static int n,m;
        static int[] dx,dy;
        public int solution(int[][] maps) {

            n = maps[0].length;
            m = maps.length;

            dx = new int[] {0,0,1,-1};
            dy = new int[] {1,-1,0,0,};

            visited = new boolean[n][m];
            minRoot = new int[n][m]; // 개수는  n*m , index는 (n-1)*(m-1)
            minRoot[0][0] = 1; // 첫 칸도 칸 수로 침

            bfs(0,0,maps); // 1,1에 대한 정보이지만 index 편의를 위해 0,0으로 표시

            System.out.println(minRoot[n-1][m-1]);

            int answer = minRoot[n-1][m-1];

            if(minRoot[n-1][m-1] == 0){
                return -1;
            } else {
                return answer;
            }

        }

        private static void bfs(int x, int y, int[][] maps){
            Queue<int[]> que = new LinkedList<>();
            que.offer(new int[] {x,y});
            visited[0][0] = true;

            while(!que.isEmpty()){
                int[] now = que.poll();

                for(int k = 0; k<4; k++){
                    int nextX = now[0]+dx[k]; // index를 가리킴
                    int nextY = now[1]+dy[k];

                    if(nextX >= 0 && nextY >=0 && nextX < n && nextY <m){ // 1. 벗어나는지
                        if (!visited[nextX][nextY] && maps[nextY][nextX] == 1){// 2. 방문배열 + 추가조건
                            visited[nextX][nextY] = true;
                            // System.out.println(nextX+"+"+ nextY);
                            minRoot[nextX][nextY] = minRoot[now[0]][now[1]] +1;
                            // System.out.println(minRoot[nextX][nextY]+"kk");
                            que.offer(new int[] {nextX, nextY});
                        }
                    }

                }


            }

        }
    }

    ////////////////////////////////////////////////////////////


    class Solution2 {
        static int n,m;
        static int[] dx,dy;
        static int[][] map;
        static boolean[][] visited;
        static int[][] minRoot;
        public int solution(int[][] maps) {
            int answer = 0;

            map = maps;

            n = maps[0].length;
            m = maps.length;

            dx = new int[] {0,0,1,-1};
            dy = new int[] {1,-1,0,0};

            visited = new boolean[n][m];
            minRoot = new int[n][m]; // 개수는  n*m , index는 (n-1)*(m-1)
            minRoot[0][0] = 1; // 첫 칸도 칸 수로 침

            bfs(0,0); // 1,1 이지만 index 편의를 위해 0,0으로 표시

            answer = minRoot[n-1][m-1];

            if ( answer == 0 ){
                return -1;
            } else {
                return answer;
            }
        }

        private static void bfs(int i, int j){
            Queue<int []> que = new LinkedList<>();
            que.offer(new int[] {i,j});
            visited[i][j] = true;

            while(!que.isEmpty()){
                int[] now = que.poll();
                int x = now[0];
                int y = now[1];

                for (int k=0;k<4;k++){
                    int[] next = {x+dx[k],y+dy[k]};
                    int nextX=next[0]; // int nextX = now[0] + dx[k];
                    int nextY=next[1]; // int nextY = now[1] + dy[k];

                    if(nextX >= 0 && nextY >=0 && nextX < n && nextY < m){ // 벗어나는지
                        if(!visited[nextX][nextY] && map[nextY][nextX] == 1){ //방문배열 + 추가조건
                            visited[nextX][nextY] = true;
                            // System.out.println(nextX+"+"+ nextY);
                            minRoot[nextX][nextY] = minRoot[x][y]  + 1;
                            // System.out.println(minRoot[nextX][nextY]+"kk");
                            que.offer(new int[]{nextX, nextY});

                        }
                    }
                }
            }
        }

    }
}
