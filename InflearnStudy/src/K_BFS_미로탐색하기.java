import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class K_BFS_미로탐색하기 {
    // 아래 = +y 기준
    // (dx[i],dy[i]) = 하우상좌 (아래,오른쪽,위쪽,왼쪽)
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int[][] A;
    static int N,M;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        // 세로 N, 가로 M 입력받기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        // A[x][y] = (x,y)에 있는 숫자가 나오게 할 거임.
        // 문제에서 밑으로 갈 수록 +1 이 되도록 할 것이기에 [N][M]으로 설정
        A = new int[N][M];
        visited = new boolean[N][M]; // 방문 배열
        /////////사전 세팅 끝 ////////

        // 입력 받아 A[][] 배열에 초기화 시키기
        for (int i =0;i<N; i++){
            st = new StringTokenizer(in.readLine());
            String line = st.nextToken();
            for(int j=0;j<M; j++){
                A[i][j] = Integer.parseInt(line.substring(j,j+1));
            }
        }
        BFS(0,0);
        // 세로 N줄, 가로 M줄 이므로, index 로는 -1씩 해줘야 함
        System.out.println(A[N-1][M-1]);
    }
    private static void BFS(int i, int j){
        // Queue 하나에 [x,y] 를 넣을 것임
        // offer 는 값 추가 실패 시 false 반환, add() 는 에러 반환
        Queue<int[]> myQueue = new LinkedList<>();
        myQueue.offer(new int[] {i,j});
        // DFS 는 스택이 비어있을 때까지 반복 or 방문배열 전부 False
        // BFS 는 큐가 비어있을 때까지 반복 or 방문 배열 전부 flase
        while(!myQueue.isEmpty()){
            // 처음은 시작할 때 큐로 빼면서 시작 : [0,0]
            // + 처음 뺀거에 대한 방문배열 true 만들기
            int now[] = myQueue.poll();
            visited[i][j] = true;
            for(int k=0;k<4;k++){
                // now[]에는 [0,0] 즉, 처음 큐에 넣었던 [x,y] 가 있음
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                // 지정된 범위 밖으로는 나갈 수 없음.
                if(x >=0 && y>=0 && x <N && y<M ){
                    // 0인 곳은 지나갈 수 없음 + 방문배열이 false 일 때 지나감
                    if(A[x][y]!=0 && !visited[x][y]){
                        visited[x][y] = true; // 지나갔을 때 방문배열 true 로 변경
                        // 처음 시작이 0이었기 때문에
                        // 현재 위치 += 지난 위치 + 1 (계속해서 증가)
                        // 즉, 지나온 거리에 따라 현재 위치가 계속해서 증가 = 최솟값
                        A[x][y] = A[now[0]][now[1]] + 1;
                        // 큐에 현재 위치 추가
                        myQueue.add(new int[] {x, y});

                    }
                }

            }


        }
    }
}
