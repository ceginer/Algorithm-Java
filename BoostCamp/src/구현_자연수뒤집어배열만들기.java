public class 구현_자연수뒤집어배열만들기 {

    // char 에서 int 로 만들고 싶을 때, '0'을 빼면 아스키코드를 통해 쉽게 변환가능
    // charAt() 은 String 에서 특정 인덱스를 뽑을 때 유용
    // 동시에 두가지 조건을 모두 만족시켜야 할 때, 한개는 for문 , 한 개는 그냥 특정 int를 지정해서 풀었음.

    class Solution {
        public int[] solution(long n) {
            String num = String.valueOf(n);
            int acc = num.length();
            int[] answer = new int[acc];

            for(int i=0;i<num.length();i++){
                answer[i] = num.charAt(acc-1)-'0';
                acc = acc -1;
            }
            return answer;
        }
    }

    class Solution2 {
        public int[] solution(long n) {
            String s = String.valueOf(n);
            StringBuilder sb = new StringBuilder(s);
            sb = sb.reverse();
            String[] ss = sb.toString().split("");

            int[] answer = new int[ss.length];
            for (int i=0; i<ss.length; i++) {
                answer[i] = Integer.parseInt(ss[i]);
            }
            return answer;
        }
    }
}
