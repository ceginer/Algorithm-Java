public class 자릿수더하기_1 {
    public class Solution {
        public int solution(int n) {
            // int로 주어진 수를 String으로 바꿔 풀어보는 유형
            // String.toString() 보다는 String.valueOf().split("") 이 좋다.
            // String.toString() 은 null 에러, String.valueOf() 은 null 그대로 출력함.
            int answer = 0;
            String num = Integer.toString(n);
            char[] A = num.toCharArray();
            // -> char[] A = Integer.toString(n).toCharArray();
            // 혹은 -> String[] array = String.valueOf(n).split("");

            for (int i=0;i<A.length;i++){
                answer += A[i] - '0';
            }

            // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
            System.out.println(answer);

            return answer;
        }
    }
}
