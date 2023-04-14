import java.util.*;

public class 해시_폰켓몬 {
    // HashSet<Integer>(Arrays.asList()); 로 풀려고 했지만
    // 주어지는 int[] 배열에 관해서는 asList() 가 불가능하단다.
    // 왜? int[] 배열이 아닌 Integer[] 배열이여야 하기 때문에 asList 가 안된단다.
    class Solution {
        public int solution(int[] nums) {
            HashSet<Integer> mySet = new HashSet<Integer>();
            for (int i : nums){
                mySet.add(i);
            }
            if (nums.length /2 > mySet.size() ){
                return mySet.size();
            } else {
                return nums.length/2;
            }
        }
    }
}
