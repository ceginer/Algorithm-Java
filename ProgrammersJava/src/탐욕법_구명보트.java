import java.util.*;


public class 탐욕법_구명보트 {

    class Solution {
        public int solution(int[] people, int limit) {
            int count = 0;
            Arrays.sort(people);

            int start = 0;
            int end = people.length-1;

            while(start<=end){
                if(start==end){
                    count ++;
                    break;
                } else if(people[start]+people[end] <= limit){
                    count++;
                    start++;
                    end--;
                } else {
                    end--;
                    count++;
                }
            }
            return count;

        }
    }
}
