import java.util.*;

public class 해시_전화번호목록 {

    class Solution1 {
        public boolean solution(String[] phone_book) {
            // 1번재 풀이 -> 정렬 후 배열
            // 정렬하면 String 이므로 "1", "12", "123" 이런식으로 계속 가능
            // contains() 혹은 startsWith() 사용가능!

            // 2번째 풀이 ->> hashmap 이용
            // Map.containsKey() 로 key값 찾기!
            // String.substring() 할 때 소문자 s인거 주의!!!!!!!

            Arrays.sort(phone_book);
            for(int i =0;i<phone_book.length-1;i++){
                if (phone_book[i+1].startsWith(phone_book[i])){
                    return false;
                }
            }
            return true;
        }
    }

    class Solution2 {
        public boolean solution(String[] phone_book) {

            Map<String, Integer> myMap = new HashMap<>();
            for (String i : phone_book){
                myMap.put(i,1);
            }
            // 정답 풀이
            // for(int i=0; i<phone_book.length;i++){
            //     for (int j =1; j<phone_book[i].length();j++){
            //         if(myMap.containsKey(phone_book[i].substring(0,j)))
            //             return false;
            //     }
            // }

            // 내 풀이
            for (String num : phone_book){
                for( int i=0;i<num.length();i++){
                    if(myMap.containsKey(num.substring(0,i))){
                        return false;
                    }
                }
            }
            return true;
        }
    }


}
