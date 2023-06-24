import java.util.*;


public class 구현_카카오오픈채팅방 {
    class Solution {
        public String[] solution(String[] record) {
            String[] answer = {};

            Map<String,String> user = new HashMap<>();
            int count = 0;


            for(int i=0;i<record.length;i++){
                String[] str = record[i].split(" ");

                if(str[0].equals("Enter")){
                    user.put(str[1],str[2]);
                    count++;
                } else if(str[0].equals("Change")){
                    user.put(str[1],str[2]);
                } else if(str[0].equals("Leave")){
                    count++;
                }
            }

            // String[] result = new String[count];
            // int n=0;

            List<String> list = new ArrayList<>();

            for(int i=0;i<record.length;i++){
                String[] str = record[i].split(" ");

                if(str[0].equals("Enter")){
                    // result[n] = user.get(str[1]) + "님이 들어왔습니다.";
                    // n++;
                    list.add(user.get(str[1]) + "님이 들어왔습니다.");
                } else if(str[0].equals("Leave")){
                    // result[n] = user.get(str[1]) + "님이 나갔습니다.";
                    // n++;
                    list.add(user.get(str[1]) + "님이 나갔습니다.");
                }

            }
            String[] ans = new String[list.size()];
            for(int i=0;i<list.size();i++){
                ans[i] = list.get(i);
            }

            // System.out.println(Arrays.toString(result));

            return ans;
        }

    }
}
