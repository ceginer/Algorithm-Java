import java.util.*;

import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        // int answer = 0;
        Queue<Integer> que = new LinkedList<>();
        HashMap<Integer,Integer> map = new HashMap<>();

        int want = priorities[location];
        int k = priorities.length;
        int count =1;
        for (int i: priorities ){
            que.add(i);
        }
        // 사전 세팅 끝
        while(!que.isEmpty()){
            int a = que.poll();
            int[] q = new int[que.size()];
            for (int i=0; i<que.size();i++){
                q[i] = que.poll();
                que.add(q[i]);
            }
            for (int i=0; i<q.length;i++){
                if(a < q[i]){
                    que.add(a);
                    System.out.println(que.toString());
                    break;
                }
                if (i==k-1){
                    map.put(a,count);
                    count++;
                    System.out.println(que.toString());
                }
            }
        }
        int answer = map.get(want).intValue();
        return answer;
    }

    public static void main(String[] args) {
        int[] priorities = {
            2, 1, 3, 2
        };
        int location = 2;
        Solution sol = new Solution();
        System.out.println(sol.solution(priorities, location));
    }
}
