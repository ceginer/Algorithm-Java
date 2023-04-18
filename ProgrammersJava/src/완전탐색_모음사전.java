import java.util.*;


public class 완전탐색_모음사전 {

    class Solution {
        static ArrayList<String> list = new ArrayList<>();
        static String str;
        public int solution(String word) {
            int answer = 0;

            str = "AEIOU";
            // 1. 재귀로 모든 조합 list에 저장
            recursive("",0);
            // 2. sort로 string 정렬
            // 3. for 문으로 비교해서 i출력
            for (int i=0;i<list.size();i++){
                if(list.get(i).equals(word)){
                    answer = i+1;
                }
            }

            return answer;
        }

        public static void recursive(String comb, int depth){
            if (!comb.equals("")){
                list.add(comb);
                if (depth == 5){
                    return;
                }
            }
            for (int i=0; i<str.length(); i++){
                recursive(comb + str.charAt(i), depth+1);
            }
        }
    }
}
