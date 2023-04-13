public class 약수의합_1 {
    public class Solution {
        public int solution(int n) {
            // 투포인터를 사용하여 약수를 골라냄
            // 사실 수학적으로 풀면 더 좋을듯?
            int start = 0;
            int end = n;
            int sum = 0;
            while(start <= end){
                if (start*end > n){
                    end--;
                } else if(start*end < n){
                    start++;
                } else {
                    if(start == end){
                        sum = sum+start;
                    } else{
                        sum = sum + start +end;
                    }
                    start++;
                    end--;
                }
            }
            return sum;
        }
    }
}
