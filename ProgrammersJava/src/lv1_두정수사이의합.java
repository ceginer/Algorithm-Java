public class lv1_두정수사이의합 {
    class Solution {
        public long solution(int a, int b) {
            long answer = 0;
            if(a == b){
                return a;
            }
            long min=0;
            long max=0;
            if(a < b){
                min = a;
                max = b;
            } else{
                min = b;
                max =a;
            }
            long sum = 0;
            for (long i=min;i<=max;i++){
                sum += i;
            }
            return sum;
        }
    }
}
