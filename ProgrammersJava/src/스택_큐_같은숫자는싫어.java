
import java.util.*;
public class 스택_큐_같은숫자는싫어 {

    public class Solution {
        public int[] solution(int []arr) {
            List<Integer> list = new ArrayList<>();

            for (int i=0; i<arr.length-1; i++){
                if (arr[i] != arr[i+1] ){
                    list.add(arr[i]);
                }
            }
            list.add(arr[arr.length-1]);

            int[] answer = new int[list.size()];
            for(int i=0; i<list.size();i++){
                answer[i] = list.get(i);
            }

            // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
            System.out.println(answer);

            return answer;
        }
    }

}
