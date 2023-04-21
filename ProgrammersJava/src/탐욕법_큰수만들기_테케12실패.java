public class 탐욕법_큰수만들기_테케12실패 {
    class Solution {
        static String answer;
        public String solution(String number, int k) {
            answer = "";

            dfs("",number, k, number.length());
            return answer;
        }
        private static void dfs(String comb,String num, int del,int rest){
            // 탈출
            if (del == 0){
                answer = comb+num;
                // System.out.println(comb+"--"+num+"--"+del+"--"+rest+"--");
                return;
            } else if(del == rest){
                answer = comb+Math.max(num.charAt(0), num.charAt(1));
                // System.out.println(comb+"++"+num+"++"+del+"++"+rest+"++");
                return;
            }
            // if (del ==1 && rest == 2){
            //     answer = comb+Math.max(num.charAt(0), num.charAt(1));
            //     return;
            // }

            int max = 0;
            int maxIdx=0;
            for(int j=0;j<=del;j++){
                if (num.charAt(j) > max){
                    max = num.charAt(j);
                    maxIdx = j;
                }
            }

            // 진행
            dfs(comb+num.charAt(maxIdx), num.substring(maxIdx+1), del-maxIdx, rest -maxIdx);

        }
    }
}
