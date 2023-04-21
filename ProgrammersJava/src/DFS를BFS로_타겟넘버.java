import java.util.LinkedList;
import java.util.Queue;

public class DFS를BFS로_타겟넘버 {
    // 타겟넘버는 깊이가 제한된 형식이므로 DFS, BFS 방식 모두 허용될 수 있지만
    // 결국 모든 방식으로 다 돌아봐야하고(최솟값 구하는 형태가 아니고), 너비를 살펴봐야한 하는 건 아니므로
    // 사실은 DFS 가 더 적합하긴 하지만, BFS 방식으로도 2개의 que 를 이용해 해결할 수 있다.

    // -----> queue를 2번 적용해서 하나는 DFS의 depth를 나타내고,
    // ------다른 하나는 각 노드에서 now의 변하는 값을 que.offer 로 넣어줌으로써
    // ------DFS(depth, 각 노드 값의 합(=sum) )에서 매개변수의 depth와 sum을 모두 표시해줄 수 있었다.

    class Solution {
        Queue<Integer> q = new LinkedList<Integer>();
        public int solution(int[] numbers, int target) {
            int answer = 0;
            q.offer(0);
            q.offer(0);
            while(q.peek()!=null){
                int level =q.poll();
                int v = q.poll();
                if(level==numbers.length){
                    if(v==target)
                        answer++;
                }else {

                    q.offer(level + 1);
                    q.offer(v + numbers[level]);

                    q.offer(level + 1);
                    q.offer(v - numbers[level]);
                }
            }
            return answer;
        }
    }
}
