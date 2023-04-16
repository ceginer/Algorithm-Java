import java.util.*;

public class 완전탐색_카펫 {
    class Solution {
        public int[] solution(int brown, int yellow) {
            int[] answer = {};
            int sum = brown + yellow;
            int start_index = 1;
            int end_index = sum;

            int[] result = new int[2];

            while(start_index <= end_index){

                if(start_index * end_index < sum ){
                    start_index ++;
                }else if(start_index * end_index > sum){
                    end_index --;
                }else if(start_index * end_index == sum ){

                    if ((start_index -2) *(end_index -2) == yellow){
                        result[0] = end_index;
                        result[1] = start_index;
                        return result;
                    } else {
                        start_index ++;
                        end_index --;
                    }
                }
            }
            return result;
        }
    }

    // 다른 사람의 풀이, 투포인터가 아닌 에라토스테네스의 체와 같이 루트 까지 계산해서 풀었음.
    // 개인적으로 투포인터 더 선호..ㅋㅋ
    class Solution2 {
        public int[] solution(int brown, int red) {
            int n = brown + red;
            List<Integer> list = new ArrayList<Integer>();

            for(int i = 2; i <= Math.sqrt(n); i++){
                if(n % i == 0){
                    list.add(i);
                    int quotient = n/i;
                    if(i != quotient) list.add(quotient);
                }
            }

            Collections.sort(list);

            int col = 0;
            int row = 0;

            for(int i : list)
                if((col = i) >= (row = (n/i))){
                    if((col + col + row - 2 + row - 2) == brown) break;
                }

            return new int[]{col, row};
        }
    }
}
