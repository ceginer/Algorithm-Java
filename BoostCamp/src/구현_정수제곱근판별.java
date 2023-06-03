public class 구현_정수제곱근판별 {
    class Solution {
        public long solution(long n) {
            long answer = 0;
            if (n == 1){
                return 4;
            }

            long lim = (long) Math.sqrt(n);

            for(long i=1; i<=lim; i++){
                // System.out.println(n / i);
                if(n / i == i && n % i ==0){
                    return (i+1)*(i+1);
                }
            }
            return -1;
        }
    }
}
