public class 구현_하샤드수 {
    class Solution {
        public boolean solution(int x) {
            // boolean answer = true;

            String numString = String.valueOf(x);
            String[] numb = numString.split("");
            int sum = 0;
            for ( String i : numb){
                sum = sum + Integer.parseInt(i);
            }

            if(x % sum == 0){
                return true;
            }
            return false;

        }
    }
}
