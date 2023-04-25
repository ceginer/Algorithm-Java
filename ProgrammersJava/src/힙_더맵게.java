import java.util.*;

public class 힙_더맵게 {

    class Solution {
        public int solution(int[] scoville, int K) {
            int count = 0;
            PriorityQueue<Integer> que = new PriorityQueue<>();

            for(int i=0; i<scoville.length; i++){
                que.offer(scoville[i]);
            }

            while(que.peek()<K){
                if(que.size() == 1){
                    return -1;
                }
                int a = que.poll();
                int b = que.poll();
                count++;
                int res = a + b*2;
                // System.out.println(" a:"+a+" b:"+b+" count:"+count+" res:"+res);
                // System.out.println(" que:"+que.size());

                que.offer(res);
            }
            return count;

        }

    }
}
