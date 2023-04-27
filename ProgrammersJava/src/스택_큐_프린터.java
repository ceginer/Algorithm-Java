import java.util.*;

public class 스택_큐_프린터 {

    class Solution1 {
        public int solution(int[] priorities, int location) {
            int answer = 0;

            List<Process> list  = new ArrayList<>();
            for(int i=0;i<priorities.length;i++){
                list.add(new Process(i, priorities[i]));
            }

            int count =0;

            while (list.size() != 0){
                boolean isMax = false;
                Process now = list.remove(0);
                for(int i=0;i<list.size();i++){
                    if(now.priority < list.get(i).priority){
                        // System.out.println(now.priority + "qwer "+ list.get(i).priority+" i: "+i);
                        isMax = true;
                        break;
                    }
                }
                if (isMax){
//                if (list.stream().anyMatch(other -> now.priority < other.priority)){ // stream 으로 대체 가능
                    list.add(now);
                    // System.out.println(list.toString());
                    // System.out.println("q"+count);
                }else{
                    count++;
                    // System.out.println("w"+count);
                    if(now.location == location){
                        break;
                    }
                }

            }
            return count;
        }

        class Process{
            int priority;
            int location;

            public Process(int location, int priority){
                this.location = location;
                this.priority = priority;
            }
        }
    }

    class Solution2 {
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
                System.out.println(que.toString());
                int a = que.poll();

                if (que.size()==0) {
                    map.put(a,count);
                    System.out.println(map.keySet()+"2");
                    break;
                }
                int[] q = new int[que.size()];
                for (int i=0; i<que.size();i++){
                    q[i] = que.poll();
                    que.add(q[i]);
                }
                for (int i=0; i<que.size();i++){
                    if(a < q[i]){
                        que.add(a);
                        // System.out.println(que.toString());
                        break;
                    }
                    if (i==q.length-1){
                        map.put(a,count);
                        System.out.println(map.keySet()+"1");
                        count++;
                        // System.out.println(que.toString());
                    }
                }
            }
            int answer = map.get(want);
            return answer;
        }
    }
}
