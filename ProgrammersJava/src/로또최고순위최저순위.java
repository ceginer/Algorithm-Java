public class 로또최고순위최저순위 {
    class Solution {
        public int[] solution(int[] lottos, int[] win_nums) {
            // 같은 값 처리, 최고 = 0이 똑같은 숫자, 최저 0이 다른 숫자
            int count =0;
            int lucky = 0;
            int bad = 0;
            for (int mine : lottos){
                if (mine != 0){ // 0은 제외
                    for (int num : win_nums){
                        if (mine == num) count ++;
                    }
                } else {
                    lucky++;
                }
            }
            lucky += count;
            bad = count;
            // 끝
            int[] answer = {prize(lucky),prize(bad)};
            return answer;
        }

        public static int prize(int i){
            if(i == 6){
                return 1;
            } else if (i == 5){
                return 2;
            } else if (i == 4){
                return 3;
            } else if (i == 3){
                return 4;
            } else if (i == 2){
                return 5;
            } else {
                return 6;
            }

        }
    }
}
