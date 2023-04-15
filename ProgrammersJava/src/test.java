import java.util.*;

import java.util.*;
import java.util.*;

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

    public static void main(String[] args) {
        int[] citations = {
            0,1,2,5,6,7
        };
        int location = 2;
        Solution sol = new Solution();
        System.out.println(sol.solution(citations));
    }
}
