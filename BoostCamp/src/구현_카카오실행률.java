import java.util.*;


public class 구현_카카오실행률 {

    class Solution {
        public int[] solution(int N, int[] stages) {
            int[] answer = {};

            Arrays.sort(stages);
            // System.out.println(Arrays.toString(stages));

            Map<Integer,Double> failMap = new HashMap<>();

            int count = 0;
            int n = stages[0];
            for(int i=0;i<stages.length; i++){
                if( n  == N+1){
                    break;
                }
                if (n != stages[i]){
                    double fail = (double) count / (stages.length - i + count);
                    // System.out.println(fail);
                    failMap.put(n, fail);
                    n = stages[i];
                    count = 0;
                }
                count++;
            }
            if (n <= N){
                failMap.put(n,1.0);
            }
            // System.out.println(failMap.keySet());
            // System.out.println(failMap.get(4));

            for (int i=1;i<=N;i++){
                failMap.put(i,failMap.getOrDefault(i,0.0));
            }


            List<Integer> list = new ArrayList<>();
            for (int i=0;i<N;i++){
                // A[i] = i+1;
                list.add(i+1);
            }

            Collections.sort(list, (o1, o2) -> (failMap.get(o2)).compareTo(failMap.get(o1)));

            int[] A = new int[list.size()];
            for (int i=0;i<list.size();i++){
                A[i] = list.get(i);
            }

            return A;
        }
    }
}
