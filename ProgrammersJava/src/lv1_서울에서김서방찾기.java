public class lv1_서울에서김서방찾기 {
    class Solution {
        public String solution(String[] seoul) {
            String answer = "";

            for(int i=0; i< seoul.length; i++){
                if (seoul[i].equals("Kim")) {
                    return String.format("김서방은 %s에 있다",i);
                }
            }

            return answer;
        }
    }
}
