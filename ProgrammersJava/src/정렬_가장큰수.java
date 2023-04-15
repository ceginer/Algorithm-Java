import java.util.*;

public class 정렬_가장큰수 {

    class Solution {
        public String solution(int[] numbers) {
            String answer = "";
            ArrayList<String> list = new ArrayList<>();
            // String a = Integer.toString(numbers[0]);
            // System.out.println(Arrays.sort(list));
            for (int i=0; i<numbers.length; i++){
                list.add(Integer.toString(numbers[i]));
            }

            Collections.sort(list, (o1,o2) -> (o2+o1).compareTo(o1+o2));
            // System.out.println(list);

            if(list.get(0).equals("0")){
                return "0";
            }

            for(int i =0; i<list.size(); i++){
                answer += list.get(i);
            }


            return answer;
        }
    }
}
