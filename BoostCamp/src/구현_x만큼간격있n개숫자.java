public class 구현_x만큼간격있n개숫자 {

    class Solution {
        public long[] solution(int x, int n) {
            long[] ans = new long[n];
            long sum = 0;
            for(int i=0;i<n;i++){
                sum += x;
                ans[i] = sum;

            }
            return ans;
        }
    }
}
