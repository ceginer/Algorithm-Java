import java.util.*;

public class lv1_개인정보수집유효기간 {


    class Solution {
        public int[] solution(String today, String[] terms, String[] privacies) {
            int[] answer = {};
            List<Integer> list = new ArrayList<>();

            Map<String,Integer> term = new HashMap<>();
            for(String i : terms){
                term.put(i.split(" ")[0],Integer.parseInt(i.split(" ")[1]));
            }

            int num = 1;
            for(String n : privacies){
                int[] expired = validate(n.split(" ")[0],term.get(n.split(" ")[1]));
                int[] todayday = validate(today,0);
                // System.out.println(Arrays.toString(expired)+"num :"+num);
                // System.out.println(Arrays.toString(todayday));
                if (expired[0] < todayday[0]){
                    list.add(num);
                    num++;
                    continue;
                } else if(expired[0] == todayday[0]){
                    if(expired[1] < todayday[1]){
                        list.add(num);
                        num++;
                        continue;
                    } else if(expired[1] == todayday[1]){
                        if(expired[2] <= todayday[2]){
                            list.add(num);
                            num++;
                            continue;
                        }
                    }
                }
                num++;
            }
            int[] result = new int[list.size()];
            for(int i=0; i<list.size(); i++){
                result[i]=list.get(i);
            }
            // System.out.println(Arrays.toString(result));

            return result;

        }

        public static int[] validate(String registerDay, int valid){
            String[] days = registerDay.split("\\.");
            int year = Integer.parseInt(days[0]);
            int month = Integer.parseInt(days[1]);
            int day = Integer.parseInt(days[2]);

            for(int i =0; i<valid*28; i++){
                day+=1;
                if(day > 28){
                    day = 1;
                    month += 1;
                    if(month > 12){
                        month = 1;
                        year += 1;
                    }
                }
            }
            int[] endDay = {year,month, day};
            return endDay;
        }
    }
}
