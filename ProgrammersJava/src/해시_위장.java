import java.util.HashMap;
import java.util.Iterator;

public class 해시_위장 {
    public int solution(String[][] clothes) {
        // hashmap으로 각 타입에 따른 개수 1씩 늘려주기
        // ->  map.getOrDefault(type,0)+1 사용
        // Iterator<Integer> it = map.values().iterator(); 기억!!!
        // Iterator 했을 때, Integer 조심, while(it.hasNext()) 사용, it.next() 사용!!!

        HashMap<String,Integer> map = new HashMap<>();
        for (int i=0;i<clothes.length;i++){
            String type = clothes[i][1];
            map.put(type, map.getOrDefault(type,0)+1 );
        }

        Iterator<Integer> it = map.values().iterator();
        int result = 1;

        while(it.hasNext()){
            // iterator 는 Integer 형태이므로, int 형태로 바꿔줘야 함. -> it.next().intValue()
            result = result * (it.next().intValue() +1);
        }
        // 아무것도 입지 않은 경우 빼주기
        return result -1;

    }
}
