
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

    public class Solution2 {
        public int[] solution(int []arr) {
            Queue<Integer> que = new LinkedList<>();
            que.add(arr[0]);

            for (int i=1;i<arr.length;i++){
                if(que.peek() != arr[i]){
                    que.add(arr[i]);
                }
                System.out.println(que.toString()+"1");
            }
            System.out.println(que.toString()+"5");
            int a = que.size();
            int [] A = new int[a];
            for(int i=0;i<a;i++){
                A[i] = que.poll();
            }
            return A;
        }
    }

}
