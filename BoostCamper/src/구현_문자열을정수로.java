public class 구현_문자열을정수로 {
    class Solution {
        public int solution(String s) {
            int answer = 0;

            if(s.startsWith("-")){
                answer = Integer.parseInt(s.substring(1));
                answer = answer*(-1);
            } else {
                answer = Integer.parseInt(s);
            }

            return answer;
        }
    }
}
