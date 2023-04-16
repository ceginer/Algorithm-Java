import java.util.*;


public class 완전탐색_소수찾기 {

    class Solution {
        HashSet<Integer> numberSet = new HashSet<>();
        public boolean isPrime(int num){
            //1. 0과 1은 소수 X
            if (num == 1 || num == 0){
                return false;
            }
            //2. limit = 루트까지인데, 앞에 int를 붙혀 소숫점은 버리면 됨.
            int limit = (int) Math.sqrt(num);

            //3. 나누어떨어지면 소수 X
            for(int i =2; i<=limit; i++){
                if(num%i == 0){
                    return false;
                }
            }

            return true;
        }
        public void recursive(String comb, String others){
            // 1. 예외조건 or 탈출조건
            if (!comb.equals("")){
                numberSet.add(Integer.valueOf(comb));
            }
            // 2. 반복되는 일상 속에
            for (int i=0; i<others.length(); i++){
                recursive(comb+others.charAt(i), others.substring(0,i)+others.substring(i+1));
            }
        }

        public int solution(String numbers) {
            // 1. 재귀식으로 모든 경우의 수 HashSet에 정리
            recursive("", numbers);
            System.out.println(numberSet);

            // 2. 에라토스테네스 체 사용
            int count =0;
            Iterator<Integer> iter = numberSet.iterator();
            while(iter.hasNext()){
                int a = iter.next();
                if(isPrime(a)){
                    count++;
                }
            }


            return count;
        }
    }
}
