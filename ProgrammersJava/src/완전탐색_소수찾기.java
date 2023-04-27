import java.util.*;


public class 완전탐색_소수찾기 {

    class Solution { //내가 직접 풀어본 sol
        HashSet<Integer> set = new HashSet<>();
        public int solution(String numbers) {
            // 1.재귀
            recursive("",numbers);
            System.out.println(set);
            // 2.소수 거르기 -> isPrime()
            int count = 0;
            // set은 get 메서드가 없으므로, for문 따위 되지않음 ^_^
            Iterator<Integer> iter = set.iterator();
            while(iter.hasNext()){
                if(isPrime(iter.next())){
                    count++;
                }
                // System.out.println("count : " + count);
            }
            // 3.개수 return
            return count;
        }
        public void recursive(String comb, String other){
            if(!comb.equals("")){
                set.add(Integer.valueOf(comb));
            }
            for(int i=0;i<other.length();i++){
                recursive(comb+other.charAt(i), other.substring(0,i)+other.substring(i+1));
            }
        }

        public boolean isPrime(int num){
            //1. 0과 1 제외
            if(num == 0 || num == 1){
                return false;
            }
            // 2. limit하는데 소숫점 다 버려
            int limit = (int) Math.sqrt(num);
            //3 계산
            for(int i=2; i<=limit; i++){
                if(num % i == 0){
                    return false;
                }
            }

            return true;
        }
    }

    class Solution2 {
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
            // set은 get 메서드가 없으므로, for문 따위 되지않음 ^_^
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
