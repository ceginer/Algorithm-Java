public class 구현_문자열내PY개수 {

    // 개수가 같음을 비교할 때는 count = 0으로 설정한 뒤, 계속 빼거나 더하는 식으로 하는 계산법 좋음.
    // char 은 == 'p' 식으로 하면 좋습니다.
    // charAt 잘 사용하자!!


    class Solution {
        boolean solution(String s) {
            boolean answer = true;
            int count1 = 0;
            int count2 = 0;
            String[] str1 = s.split("");

            for(int i=0;i<s.length();i++){
                if(str1[i].equals("p") | str1[i].equals("P")){
                    count1 += 1;
                }
                if(str1[i].equals("y") | str1[i].equals("Y")){
                    count2 += 1;
                }

            }

            if(count1 == count2){
                return true;
            }
            return false;
            // System.out.println(s.charAt(0));
            // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        }

    }
    class Solution2 {
        boolean solution(String s) {
            s = s.toLowerCase();
            int count = 0;

            for (int i = 0; i < s.length(); i++) {

                if (s.charAt(i) == 'p')
                    count++;
                else if (s.charAt(i) == 'y')
                    count--;
            }

            if (count == 0)
                return true;
            else
                return false;
        }
    }
}
