import java.util.*;
import java.util.Iterator;
public class lv1_신고결과받기 {


    class Solution {
        public int[] solution(String[] id_list, String[] report, int k) {
            int[] answer = {};
            Set<String> twoTime = new HashSet<>();
            Map<String,Integer> user = new HashMap<>();
            Map<String,Integer> callMap = new HashMap<>();
            Set<String> locked = new HashSet<>();

            //중복 제거
            for(String n : report){
                twoTime.add(n);
            }

            // Iterator<String> iter = twoTime.iterator();
            // while(iter.hasNext()){
            //     System.out.println("iter : "+iter.next());
            // }
            // 유저별 신고당한 Map, 제재 유저 Set
            for(String n : twoTime){
                // System.out.println("iter : "+n.split(" ")[1]);

                callMap.put(n.split(" ")[1],
                        callMap.getOrDefault(n.split(" ")[1],0)+1);
                if(callMap.get(n.split(" ")[1]) >= k){
                    locked.add(n.split(" ")[1]);
                }
            }
            // 유저별 신고한 ID가 제대 ID이면 갯수 증가
            for(String n : twoTime){
                if (locked.contains(n.split(" ")[1])){
                    user.put(n.split(" ")[0],
                            user.getOrDefault
                                    (n.split(" ")[0],0)+1);
                }
            }

            // result
            int[] result = new int[id_list.length];
            for(int i=0;i<id_list.length;i++){
                result[i] = user.getOrDefault(id_list[i],0);
            }

            // System.out.println(Arrays.toString(result));


            return result;
        }
    }
}
