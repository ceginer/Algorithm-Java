import java.util.*;

public class 스택_큐_기능개발 {
    // 아직도 왜 안되었는지 모르겠음.... 효율성테스트 통과 X

    import java.util.*;

    class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            List<Integer> list = new LinkedList<>();
            int [] days = new int[progresses.length];
            int day;
            // (100-progresses) % speed != 0 -> 몫+1
            for (int i =0;i<progresses.length; i++){
                // if((100-progresses[i] ) % speeds[i] == 0){
                //     day = (100-progresses[i]) / speeds[i];
                // } else{
                //     day = (100-progresses[i]) / speeds[i] + 1;
                // }
                double dayss = (100-progresses[i] ) / (double) speeds[i];
                days[i] = (int) Math.ceil(dayss);
            }

            int count =1;

            // 앞에보다 클 때 순서대로 집어넣기
            for (int i=1; i<progresses.length; i++){
                if(days[i]<=days[i-1]){
                    count++;
                } else {
                    list.add(count);
                    count =1;
                }
            }
            list.add(count);

            int[] answer = new int[list.size()];
            for (int i=0; i<list.size();i++){
                answer[i] = list.get(i);
            }
            return answer;
        }
    }
}
