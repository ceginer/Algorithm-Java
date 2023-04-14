import java.util.*;

public class 해시_완주하지못한선수 {
    // 1. 내가 생각한 ArrayList 에 모두 넣어서 completion 을 빼자는 내 생각 -> 효율성 테스트 실패
    // -> LinkedList를 사용해도 for문 + 삭제하는 것에 대해서는 괜찮은데 get할 때 문제?(1개 남았는데?) 인거 같음
    // -> Arrays.asList() 기억!!!!

    // 2. hashmap 을 이용한 풀이 -> 정석 풀이, 뭔가 찾아서 할 때는 hashmap 쓰면 빨리 풀 수 있음.
    // -> HashMap.getOrDefault(a,b) 랑 HashMap.keySet() 기억 !!!

    // 3. sort로 정렬 이후, for문을 이용한 풀이 -> 뭔가 찾아서 푸는 경우, sort하고 for문 돌리면 쉽게 해결할 수 있는듯.
    // -> String 이 똑같은지 비교할 때는 equals() 써야해!!!!, if not 은 if(!~~~) "!" 붙히기!!
    // Arrays.toString() 쓰면 String값 배열 볼 수 있음!

    class Solution1 {
        public String solution(String[] participant, String[] completion) {
            List<String> runner = new LinkedList<>(Arrays.asList(participant));
            for(String i : completion){
                runner.remove(i);
            }
            System.out.println(runner.get(0));
            return runner.get(0);
        }
    }
    class Solution2 {
        public String solution(String[] participant, String[] completion) {
            String answer = "";
            HashMap<String, Integer> myMap = new HashMap<>();
            for (String player : participant){
                myMap.put(player, myMap.getOrDefault(player, 0) + 1 );
            }
            for (String player : completion){
                myMap.put(player, myMap.get(player) -1);
            }
            for (String key : myMap.keySet()){
                if (myMap.get(key) != 0){
                    answer = key;
                    break;
                }
            }
            return answer;
        }
    }
    class Solution3 {
        public String solution(String[] participant, String[] completion) {
            String answer ="";
            Arrays.sort(participant);
            Arrays.sort(completion);
            for (int i=0; i<completion.length;i++){
                if (!completion[i].equals(participant[i])){
                    answer = participant[i];
                    return answer;
                }
            }
            return participant[participant.length-1];

        }
    }

}
