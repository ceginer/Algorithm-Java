import java.util.*;

public class 정렬_H_index {

    class Solution {
        public int solution(int[] citations) {
            int answer = 0;
            Arrays.sort(citations);
            System.out.println(Arrays.toString(citations));

            for(int i= 0;i<citations.length;i++){
                int remainLen = citations.length - i;
                System.out.println(citations[i]+"ll"+ remainLen);

                if(citations[i] >= remainLen){
                    answer = remainLen;
                    break;
                }

            }
            return answer;
        }
    }
}
