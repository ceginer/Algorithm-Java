import java.util.*;


public class lv1_성격유형검사하기 {

    class Solution {
        public String solution(String[] survey, int[] choices) {
            String answer = "";
            Map<Integer,Integer> numMap = new HashMap<>();
            Map<String,Integer> point = new HashMap<>();
            numMap.put(1,3);
            numMap.put(2,2);
            numMap.put(3,1);
            numMap.put(4,0);
            numMap.put(5,1);
            numMap.put(6,2);
            numMap.put(7,3);

            for(int i=0; i< survey.length; i++){
                int num = numMap.get(choices[i]);
                String n,m ="";
                if(choices[i] < 4){
                    n = survey[i].substring(0,1);
                    // m = survey[i].substring(1);
                } else {
                    // m = survey[i].substring(0,1);
                    n = survey[i].substring(1);
                }
                point.put(n,point.getOrDefault(n,0)+num);

            }
            System.out.println(point.get("C"));
            // 점수 비교
            String[] compare = {"R","T","C","F","J","M","A","N"};
            for(int i=0;i<4;i++){
                point.put(compare[2*i],point.getOrDefault(compare[2*i],0));
                point.put(compare[2*i+1],point.getOrDefault(compare[2*i+1],0));
                if(point.get(compare[2*i]) >= point.get(compare[2*i+1])){
                    answer += compare[2*i];
                } else {
                    answer += compare[2*i+1];
                }
            }


            return answer;
        }
    }
}
