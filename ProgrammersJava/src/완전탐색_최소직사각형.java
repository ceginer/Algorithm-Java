import java.util.*;

public class 완전탐색_최소직사각형 {

    class Solution {
        public int solution(int[][] sizes) {
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();

            for(int i =0; i< sizes.length; i++){
                list1.add(Math.max(sizes[i][0],sizes[i][1]));
                list2.add(Math.min(sizes[i][0],sizes[i][1]));
            }

            int a = Collections.max(list1);
            int b = Collections.max(list2);

            return a*b;


        }
    }
        class Solution2 {
        public int solution(int[][] sizes) {
            int maxM = 0;
            int minM =0;
            for(int i =0; i<sizes.length;i++){
                int a = Math.max(sizes[i][0],sizes[i][1]);
                int b = Math.min(sizes[i][0],sizes[i][1]);
                if(maxM < a){
                    maxM = a;
                }
                if(minM < b){
                    minM = b;
                }
//                System.out.println(maxM + "qwer" + minM);
            }
            int answer = maxM*minM;
            return answer;


        }
    }
}
