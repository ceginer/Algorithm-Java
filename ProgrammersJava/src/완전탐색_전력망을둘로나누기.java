import java.util.*;


public class 완전탐색_전력망을둘로나누기 { // bfs로도 풀어보고, dfs로도 풀어봤음

    // 큐.스택 쓸것인가 재귀 쓸것인가
// 큐, 스택 => while 문
// 여기선 재귀 => for문
    class Solution1 { // dfs 방식, bfs 둘다 가능

        static ArrayList<Integer>[] list;
        static boolean visited[];
        static int any = 0;
        static int count = 0;
        public int solution(int n, int[][] wires) {

            // 사전세팅
            int answer = 100; // 최악의 경우일 때,


            list = new ArrayList[n+1];
            for (int i=1; i<n+1; i++){
                list[i] = new ArrayList<Integer>();
            }

            for (int[] wire : wires){
                int a = wire[0];
                int b = wire[1];
                list[a].add(b);
                list[b].add(a);
            }
            // 사전세팅 끝
            System.out.println("22");

            for(int i=0; i<wires.length; i++){
                count = 1;
                visited = new boolean [n+1];
                visited[wires[i][0]] = true;
                int n1 = dfs(wires[i][0],wires[i][1],1);
                System.out.println(count);
                int n2 = n-n1;

                answer = Math.min(answer, Math.abs(n1-n2));
            }


            return answer;
        }
        public static int dfs(int v1, int v2, int depth){
            // System.out.println(count+"시작");
            for(int i : list[v1]){
                if (!visited[i] && i != v2){
                    visited[i] = true;
                    count++;
                    depth = dfs(i,i,depth+1);
                    // System.out.println("22222");
                }

            }
            // System.out.println(count+"Rmx");

            return count;
        }
    }

    class Solution2 { // bfs 방식
        static ArrayList<Integer>[] list;

        public int solution(int n, int[][] wires) {
            // 사전세팅
            int answer = 100; // 최악의 경우일 때,

            list = new ArrayList[n+1];
            for (int i=1; i<n+1; i++){
                list[i] = new ArrayList<Integer>();
            }

            for (int[] wire : wires){
                int a = wire[0];
                int b = wire[1];
                list[a].add(b);
                list[b].add(a);
            }

            // 사전세팅 끝
            System.out.println("22");
            for (int i =0; i< wires.length; i++){
                // 연결을 끊기 위한 wires[i][1] , boolean 지정을 위한 n
                int n1 = bfs(wires[i][0],wires[i][1], n);
                int n2 = n-n1;
                // int n2 = bfs(wires[i][1],wires[i][0], n);
                System.out.println(n1);

                answer = Math.min(answer, Math.abs(n1-n2));

            }

            return answer;
        }

        public static int bfs(int v1, int v2, int n){
            Queue<Integer> que = new LinkedList<>();
            boolean visited[] = new boolean [n+1]; // 각 노드 마다의 visited 가 여기 생성해야 계속 초기화 됨

            int count = 0; // bfs의 b를 count로 지정,
            que.offer(v1); // 상위의 노드 큐에 넣기
            visited[v1] = true; // 자식노드로 갔다가 다시 돌아올 일 없도록 하기 위해 true 설정

            while(!que.isEmpty()){
                int now = que.poll(); // 큐 꺼내기 = 현재 노드
                count ++; // poll 이 2번 -> bfs 넓이 = 2번 이므로 poll 할 때 count 세기

                for(int i : list[now]){ // 인접리스트를 참고해 다시 탐색 시작
                    if(!visited[i] && i != v2 ){
                        visited[i] = true;
                        que.add(i);
                    }
                }
            }

            return count;
        }
    }
}
