public class lv1_콜라흐추측 {

    // -> while 문의 조건은 (~할 때까지의 반대) 이다.
    // 즉, num 이 1이 될때까지 반복이면, while(num != 1) 인 것이다.

    class Solution {
        public int solution(int num) {
            int answer = 0;

            if (num == 1) return 0;
            int count = 0;

            while(num != 1){
                if(num % 2 == 0){
                    num = num / 2;
                } else if (num % 2 == 1){
                    num = num*3 + 1;
                }
                count++;
                if(count >= 500){
                    return -1;
                }
            }

            return count;
        }
    }
}
